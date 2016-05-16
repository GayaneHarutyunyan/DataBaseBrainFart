package app;

import model.Tests;
import model.Users;

import javax.validation.*;
import java.util.*;

/**
 * Created by mystic on 16.05.2016.
 */
public class ValidationModel {

    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();


        validatorUsers(validator);
        validatorTestSession(validator);
        validatorTests(validator);
    }

    private static void validatorTests(Validator validator) {
        Tests tests = new Tests();
        Set<ConstraintViolation<Tests>> constrsTests = validator.validate(tests);
        for (ConstraintViolation<Tests> constrTests : constrsTests) {
            StringBuilder stringBuilder = new StringBuilder("PropertyTests: ");
            //название поля где была ошибка
            stringBuilder.append(constrTests.getPropertyPath());
            stringBuilder.append(" valueTests: ");
            stringBuilder.append(constrTests.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" messageTests: ");
            stringBuilder.append(constrTests.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }

    private static void validatorTestSession(Validator validator) {
        Tests testSession = new Tests();
        Set<ConstraintViolation<Tests>> constrsTestS = validator.validate(testSession);

        for (ConstraintViolation<Tests> constrTestS : constrsTestS) {
            StringBuilder stringBuilder = new StringBuilder("PropertyTestSession: ");
            //название поля где была ошибка
            stringBuilder.append(constrTestS.getPropertyPath());
            stringBuilder.append(" valueTestSession: ");
            stringBuilder.append(constrTestS.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" messageTestSession: ");
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
            stringBuilder.append(" valueUsers: ");
            stringBuilder.append(constr.getInvalidValue());
            //сообщение с ошибой
            stringBuilder.append(" messageUsers: ");
            stringBuilder.append(constr.getMessage());
            System.out.println(stringBuilder.toString());
        }
    }
}
