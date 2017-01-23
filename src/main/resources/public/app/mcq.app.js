
var mcq_app = new Vue({
    el: '#mcq',
    data:{
        message: 'Hello world!!!',
    questions: []
    },
     methods: {

        removeQuestion(index) {
          this.questions.splice(index, 1)
        },

        loadAllQuestions(){

        this.$http.get('mcq/findAll').then(function (response){
                this.questions = this.questions.concat(response.body);
        }).catch(function(error) {
            console.log(error);
        });


        }
      }
});
