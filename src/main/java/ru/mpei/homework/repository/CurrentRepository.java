package ru.mpei.homework.repository;

import ru.mpei.homework.model.Current;

import java.util.List;

public interface CurrentRepository {
    //добавление точки в БД
    void addPoint(double ia, double ib, double ic);
    //поиск поврежденных фаз
    List<Current> findFault1(long startIndex, long endIndex);
}
