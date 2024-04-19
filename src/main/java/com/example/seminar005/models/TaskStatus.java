package com.example.seminar005.models;
//уточнить где хранить перерчисления в структуре проекта
public enum TaskStatus {
    NOT_STARTED("не начата"), IN_PROGRESS("в работе"), COMPLETED("выполнена");
    private String title;

    TaskStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
