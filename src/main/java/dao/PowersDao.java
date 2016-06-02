package dao;

import exception.*;
import modelAdmin.*;

import java.util.*;

/**
 * Created by gaya on 02.06.2016.
 */
public interface PowersDao {
    void addPowers(Powers powers) throws DaoRuntimeException;

    Powers readPowers(long id) throws DaoRuntimeException;

    void updatePowers(Powers powers) throws DaoRuntimeException;

    void deletePowers(Powers powers) throws DaoRuntimeException;

    List<Powers> getPowers() throws DaoRuntimeException;
}
