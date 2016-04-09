package handler;

import dal.AnswerFacade;
import dal.QuestionFacade;
import dal.QuestionnaireFacade;
import entity.Answer;
import entity.Question;
import entity.Questionnaire;
import handlerinterface.QuestionnaireHandlerLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

/**
 * Created by u95599 on 2016.03.08.
 */

@Stateless
public class QuestionnaireHandler implements QuestionnaireHandlerLocal {

    @EJB
    QuestionnaireFacade questionnaireFacade;

    @EJB
    QuestionFacade questionFacade;

    @EJB
    AnswerFacade answerFacade;



    @Override
    public List<Questionnaire> getQuestionnaires(){
        return questionnaireFacade.findAll();
    }

    @Override
    public void addQuestionnaire(String name, String authorFirstName, String authorLastName, Date date) {
        Questionnaire questionnaire = new Questionnaire(name, authorFirstName,authorLastName, date);
        questionnaireFacade.create(questionnaire);
    }

    @Override
    public void addQuestionnaire(Questionnaire questionnaire) {
        questionnaireFacade.create(questionnaire);
    }

    @Override
    public Questionnaire getQuestionnaire(Long id){
        return questionnaireFacade.find(id);
    }

    @Override
    public void editQuestionnaire(Questionnaire questionnaire) {
        questionnaireFacade.edit(questionnaire);
    }


    public void addAnswer(Long questionId, String name) {
        Question question = questionFacade.find(questionId);
        Answer answer = new Answer(question, name);
        answerFacade.create(answer);
    }



}
