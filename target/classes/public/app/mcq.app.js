var mcq_app = new Vue({
    el: '#mcq',
    data:{
        questions: []
    },
     methods: {

        removeQuestion(index) {
          this.questions.splice(index, 1)
        },

      /*
       * Load all unvalidate questions.
       */
        loadAllUnvalidateQuestions(){
        this.$http.get('mcq/findUnvalidate').then(function (response){
                this.questions = [];
                this.questions = this.questions.concat(response.body);
        }).catch(function(error) {
            console.log(error);
        });


        },

        /*
         * Call service in order to extract all MCQ shared by server.
         */
        extractAllQuestions(){
         this.$http.get('mcq/extractAll').then(function (response){
                       console.log('extract succeeded')
                }).catch(function(error) {
                    console.log(error);
                });
        },


        save(){
             this.$http.post('mcq/save',this.questions).then(function (response){
                                   console.log('extract succeeded')
                            }).catch(function(error) {
                                console.log(error);
                            });
      }
      }
});
