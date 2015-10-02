package com.jpuyo.deathnote.database.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.jpuyo.deathnote.database.sqlite.SQLiteHelper;

public abstract class GenericDaoImpl<T, ID> implements GenericDao<T, ID> {
	
    protected Dao<T, ID> dao;
    protected Class<T> entityClassName;

    public GenericDaoImpl(SQLiteHelper sqliteHelper){
    	try {
			createDao(sqliteHelper);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private void createDao(SQLiteHelper sqliteHelper) throws SQLException{
    	this.dao = sqliteHelper.getDao(getEntityClassName());
    }
    
    protected abstract Class<T> getEntityClassName();

    protected void throwFatalException(SQLException e) {
        String message = "An unknown SQL exception occured while executing a basic SQL command!";
        throw new RuntimeException(message, e);
    }

    @Override
    public T findByPrimaryKey(ID id) {
        T result = null;
        try {
            result = dao.queryForId(id);
        } catch (SQLException e) {
            throwFatalException(e);
        }
        return result;
    }
    
    @Override
	public List<T> findAllFromPlayer(int playerId) {
		List<T> playerRecords = new ArrayList<T>();

		try {
			QueryBuilder<T, ID> queryBuilder = dao.queryBuilder();
			queryBuilder.where().eq("player", playerId);
			PreparedQuery<T> preparedQuery = queryBuilder.prepare();
			playerRecords = dao.query(preparedQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 
		}

		return playerRecords;
	}

	@Override
    public T save(T entity) {
        try {
            dao.create(entity);
        } catch (SQLException e) {
            throwFatalException(e);
        }
        return entity;
    }

    @Override
    public int update(T entity) {
    	int result = 0;
        try {
            result = dao.update(entity);
        } catch (SQLException e) {
            throwFatalException(e);
        }
        return result;
    }

    @Override
    public int delete(T entity) {
        int result = 0;
        try {
            result = dao.delete(entity);
        } catch (SQLException e) {
            throwFatalException(e);
        }
        return result;
    }
    
    @Override
    public int delete(Collection<T> entityList) {
        int result = 0;
        try {
            result = dao.delete(entityList);
        } catch (SQLException e) {
            throwFatalException(e);
        }
        return result;
    }

    @Override
    public int refresh(T entity) {
        int result = -1;
        try {
             result = dao.refresh(entity);
        } catch (SQLException e) {
            throwFatalException(e);
        }
        return result;
    }

    @Override
    public void deleteAll() {
        DeleteBuilder<T, ID> deleteBuilder = dao.deleteBuilder();
        try {
            dao.delete(deleteBuilder.prepare());
        } catch (SQLException e) {
            throwFatalException(e);
        }
    }
}
