package utils;

import models.*;

import javax.validation.*;
import java.util.*;


public class ValidationModel {

    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        validatorUsers(validator);
        System.out.println("\n");
      /**  validatorTestSession(validator);
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
       */
    }

    private static void validatorAdmins(Validator validator) {
        Admin admin = new Admin();
        Set<ConstraintViolation<Admin>> constrsTests = validator.validate(admin);
        for (ConstraintViolation<Admin> constrTests : constrsTests) {
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
        Role role = new Role();
        Set<ConstraintViolation<Role>> constrsTests = validator.validate(role);
        for (ConstraintViolation<Role> constrTests : constrsTests) {
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
        AnswerOption answerOption = new AnswerOption();
        Set<ConstraintViolation<AnswerOption>> constrsTests = validator.validate(answerOption);
        for (ConstraintViolation<AnswerOption> constrTests : constrsTests) {
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
        QuestionConnection questionConnection = new QuestionConnection();
        Set<ConstraintViolation<QuestionConnection>> constrsTests = validator.validate(questionConnection);
        for (ConstraintViolation<QuestionConnection> constrTests : constrsTests) {
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
        QuestionResult questionResult = new QuestionResult();
        Set<ConstraintViolation<QuestionResult>> constrsTests = validator.validate(questionResult);
        for (ConstraintViolation<QuestionResult> constrTests : constrsTests) {
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
        Question question = new Question();
        Set<ConstraintViolation<Question>> constrsTests = validator.validate(question);
        for (ConstraintViolation<Question> constrTests : constrsTests) {
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
        Subject subject = new Subject();
        Set<ConstraintViolation<Subject>> constrsTests = validator.validate(subject);
        for (ConstraintViolation<Subject> constrTests : constrsTests) {
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
        Test test = new Test();
        Set<ConstraintViolation<Test>> constrsTests = validator.validate(test);
        for (ConstraintViolation<Test> constrTests : constrsTests) {
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
        User user = new User();
        user.setPhoneNumber("0635827207");
        user.setEmail("invalid@email.ru");
        Set<ConstraintViolation<User>> constrs = validator.validate(user);

        for (ConstraintViolation<User> constr : constrs) {
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
