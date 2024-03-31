import Dao.QuestionDao;
import Model.Answer;
import Model.Question;
import Model.Tag;
import Model.UserModel.User;
import Model.UserModel.UserType;
import Services.AnswerService;
import Exception.SOFException;
import Services.QuestionService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User guest = new User();
        User moderator = new User("moderator","mod@sof.com","modSof",UserType.Moderator);
        User member = new User("member","member@sof.com","memberSof",UserType.Member);

        Question question = new Question("What is spring",member.getId());
        question.addTag(Tag.Java);
        question.addTag(Tag.Spring);

        QuestionService questionService = new QuestionService();

        try {
            questionService.addQuestion(member,question);
            Answer answer = new Answer(member.getId(),"It is a framework");
            AnswerService answerService = new AnswerService();
            System.out.println(answerService.addAnswer(member,question,answer));
        }catch (SOFException sofException) {
            System.out.println(sofException.getMessage());
        }
    }
}