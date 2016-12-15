package com.jackbaretto.scrumtest.extractor;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by florentsailly on 14/12/2016.
 */
public class ExtractionParameters {

    private Set<File> mcqPictures = new HashSet<File>();

    private final MimetypesFileTypeMap mimeTypes = new MimetypesFileTypeMap();

    public ExtractionParameters(String mcqUrl) {
        // adding mimeTypes to be able to recognize image formats
        mimeTypes.addMimeTypes("image png tif jpg jpeg bmp");
        addMCQPictures(mcqUrl);
    }

    private void addMCQPictures(String mcqUrl) {
        final File mcqFileOrFolder = new File(mcqUrl);
        if (mcqFileOrFolder.isDirectory()) {
            // TODO : voir pour le faire en lambda
            for (File unknownFile : mcqFileOrFolder.listFiles()) {
                if (isMCQPicture(unknownFile)) {
                    mcqPictures.add(unknownFile);
                }
            }
        } else {
            mcqPictures.add(mcqFileOrFolder);
        }
    }

    private boolean isMCQPicture(File unknownFile) {
        String mcqFileMimeType = mimeTypes.getContentType(unknownFile);
        String mcqFileMimeTypePrefix = mcqFileMimeType.split("/")[0];
        return "image".equals(mcqFileMimeTypePrefix);
    }

    public Set<File> getMcqPictures() {
        return new HashSet<File>(mcqPictures);
    }
}
