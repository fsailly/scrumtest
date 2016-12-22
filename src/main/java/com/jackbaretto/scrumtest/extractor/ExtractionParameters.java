package com.jackbaretto.scrumtest.extractor;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Set up parameters for MCQ file(s) extraction..
 * Created by florentsailly on 14/12/2016.
 */
public class ExtractionParameters {

    private final Set<File> mcqPictures = new HashSet<>();

    private final MimetypesFileTypeMap mimeTypes = new MimetypesFileTypeMap();

    public ExtractionParameters(final String mcqUrl) {
        // adding mimeTypes to be able to recognize image formats
        this.mimeTypes.addMimeTypes("image png tif jpg jpeg bmp");
        addMCQPictures(mcqUrl);
    }

    private void addMCQPictures(final String mcqUrl) {
        final File mcqFileOrFolder = new File(mcqUrl);
        if (mcqFileOrFolder.isDirectory()) {
            // TODO : voir pour le faire en lambda
            for (final File unknownFile : mcqFileOrFolder.listFiles()) {
                if (isMCQPicture(unknownFile)) {
                    this.mcqPictures.add(unknownFile);
                }
            }
        } else {
            this.mcqPictures.add(mcqFileOrFolder);
        }
    }

    private boolean isMCQPicture(final File unknownFile) {
        final String mcqFileMimeType = this.mimeTypes.getContentType(unknownFile);
        final String mcqFileMimeTypePrefix = mcqFileMimeType.split("/")[0];
        return "image".equals(mcqFileMimeTypePrefix);
    }

    public Set<File> getMcqPictures() {
        return new HashSet<File>(this.mcqPictures);
    }
}
