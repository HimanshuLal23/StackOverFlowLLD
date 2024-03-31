package Services;

import Dao.QuestionDao;
import Model.Answer;
import Model.Comment;
import Model.Question;
import Model.Status;
import Model.UserModel.User;
import Model.UserModel.UserType;
import Exception.*;

public class CommentService {
    private QuestionDao questionDao;
    public CommentService() {
        questionDao = QuestionDao.getInstance();
    }
    public String addCommentToQuestion(User user, Question question, Comment comment) throws SOFException {
        if(user.getUserType()!= UserType.Member) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to add comment");
        }
        question.addComment(comment);
        return "You have successfully added the comment to the question";
    }

    public String addCommentToAnswer(User user, Answer answer, Comment comment) throws SOFException {
        if(user.getUserType()!= UserType.Member) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to add comment");
        }
        answer.addComment(comment);
        return "You have successfully added the comment to the answer";
    }

    public String deleteCommentOnQuestion(User user,Question question, Comment comment) throws SOFException {
        if(user.getUserType()!= UserType.Member) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to delete comment");
        }
        if(question.getUserId().equals(user.getId()) || comment.getUserId().equals(user.getId())) {
            question.removeComment(comment);
            return "You have successfully deleted the comment";
        }
        throw new SOFException(SOFExceptionType.InsufficientException,"You can't delete this comment");
    }

    public String deleteCommentOnAnswer(User user,Answer answer, Comment comment) throws SOFException {
        if(user.getUserType()!= UserType.Member) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to remove comment");
        }
        if(!answer.getUserId().equals(user.getId()) && !comment.getUserId().equals(user.getId())) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You can't remove this comment");
        }
        answer.removeComment(comment);
        return "You have successfully removed the comment";
    }
}
