package app;

import model.*;
import modelAdmin.*;

import javax.validation.*;
import java.util.*;


public class ValidationModel {

    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        validatorUsers(validator);
        System.out.println("\n");
        validatorTestSession(validator);
        System.out.println("\n");
        validatorTests(validator);
        System.out.println("\n");
        validatorTestAvailability(validator);
        System.out.println("\n");
        validatorSubjects(validator);
        System.out.println("\n");
        validatorQuestions(validator);
        System.out.println("\n");
        validatorQuestionResults(validator);
        System.out.println("\n");
        validatorQuestionConnections(validator);
        System.out.println("\n");
        validatorAnswerOptions(validator);
        System.out.println("\n");
        validatorAdmins(validator);
        System.out.println("\n");
        validatorPowers(validator);
    }

    private static void validatorAdmins(Validator validator) {
        Admins admins = new Admins();
        Set<ConstraintViolation<Admins>> constrsTests = validator.validate(admins);
        for (ConstraintViolation<Admins> constrTests : constrsTests) {
            StringBuilder stringBuilder = new StringBuilder("PropertyAdmins: ");
            //название поля где была ошибка
            stringBuilder.append(constrTests.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constrTests.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constrTests.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorPowers(Validator validator) {
        Powers powers = new Powers();
        Set<ConstraintViolation<Powers>> constrsTests = validator.validate(powers);
        for (ConstraintViolation<Powers> constrTests : constrsTests) {
            StringBuilder stringBuilder = new StringBuilder("PropertyPowers: ");
            //название поля где была ошибка
            stringBuilder.append(constrTests.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constrTests.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constrTests.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorAnswerOptions(Validator validator) {
        AnswerOptions answerOptions = new AnswerOptions();
        Set<ConstraintViolation<AnswerOptions>> constrsTests = validator.validate(answerOptions);
        for (ConstraintViolation<AnswerOptions> constrTests : constrsTests) {
            StringBuilder stringBuilder = new StringBuilder("PropertyAnswerOptions: ");
            //название поля где была ошибка
            stringBuilder.append(constrTests.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constrTests.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constrTests.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorQuestionConnections(Validator validator) {
        QuestionConnections questionConnections = new QuestionConnections();
        Set<ConstraintViolation<QuestionConnections>> constrsTests = validator.validate(questionConnections);
        for (ConstraintViolation<QuestionConnections> constrTests : constrsTests) {
            StringBuilder stringBuilder = new StringBuilder("PropertyQuestionConnections: ");
            //название поля где была ошибка
            stringBuilder.append(constrTests.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constrTests.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constrTests.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorQuestionResults(Validator validator) {
        QuestionResults questionResults = new QuestionResults();
        Set<ConstraintViolation<QuestionResults>> constrsTests = validator.validate(questionResults);
        for (ConstraintViolation<QuestionResults> constrTests : constrsTests) {
            StringBuilder stringBuilder = new StringBuilder("PropertyQuestionResults: ");
            //название поля где была ошибка
            stringBuilder.append(constrTests.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constrTests.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constrTests.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorQuestions(Validator validator) {
        Questions questions = new Questions();
        Set<ConstraintViolation<Questions>> constrsTests = validator.validate(questions);
        for (ConstraintViolation<Questions> constrTests : constrsTests) {
            StringBuilder stringBuilder = new StringBuilder("PropertyQuestions: ");
            //название поля где была ошибка
            stringBuilder.append(constrTests.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constrTests.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constrTests.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorSubjects(Validator validator) {
        Subjects subjects = new Subjects();
        Set<ConstraintViolation<Subjects>> constrsTests = validator.validate(subjects);
        for (ConstraintViolation<Subjects> constrTests : constrsTests) {
            StringBuilder stringBuilder = new StringBuilder("PropertySubjects: ");
            //название поля где была ошибка
            stringBuilder.append(constrTests.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constrTests.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constrTests.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorTestAvailability(Validator validator) {

        TestAvailability testAvailability = new TestAvailability();
        Set<ConstraintViolation<TestAvailability>> constrsTests = validator.validate(testAvailability);
        for (ConstraintViolation<TestAvailability> constrTests : constrsTests) {
            StringBuilder stringBuilder = new StringBuilder("PropertyTestAvailability: ");
            //название поля где была ошибка
            stringBuilder.append(constrTests.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constrTests.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constrTests.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorTests(Validator validator) {
        Tests tests = new Tests();
        Set<ConstraintViolation<Tests>> constrsTests = validator.validate(tests);
        for (ConstraintViolation<Tests> constrTests : constrsTests) {
            StringBuilder stringBuilder = new StringBuilder("PropertyTests: ");
            //название поля где была ошибка
            stringBuilder.append(constrTests.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constrTests.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constrTests.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorTestSession(Validator validator) {
        TestSession testSession = new TestSession();
        Set<ConstraintViolation<TestSession>> constrsTestS = validator.validate(testSession);

        for (ConstraintViolation<TestSession> constrTestS : constrsTestS) {
            StringBuilder stringBuilder = new StringBuilder("PropertyTestSession: ");
            //название поля где была ошибка
            stringBuilder.append(constrTestS.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constrTestS.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constrTestS.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorUsers(Validator validator) {
        Users users = new Users();
        Set<ConstraintViolation<Users>> constrs = validator.validate(users);

        for (ConstraintViolation<Users> constr : constrs) {
            StringBuilder stringBuilder = new StringBuilder("PropertyUsers: ");
            //название поля где была ошибка
            stringBuilder.append(constr.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constr.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" message: ");
            stringBuilder.append(constr.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }
}
