package controller;

import datasource.DataAccessObject;
import datasource.RunOptionDataAccessObject;
import datasource.TodoDataAccessObject;
import entity.RunOption;
import entity.Todo;
import java.util.List;

public class TodoController {

  DataAccessObject<Todo> todoDao;
  DataAccessObject<RunOption> runOptionDao;

  public TodoController() {
    todoDao = new TodoDataAccessObject("src/main/resources/task.csv");
    runOptionDao = new RunOptionDataAccessObject("src/main/resources/usage.csv");
  }

  public void listAllTodos() {
    List<Todo> todoList = todoDao.loadAll();
    for (Todo todo : todoList) {
      System.out.println(todo);
    }
  }

  public void printUsageInfo() {
    List<RunOption> runOptionList = runOptionDao.loadAll();
    for (RunOption runOption : runOptionList) {
      System.out.println(runOption);
    }
  }
}
