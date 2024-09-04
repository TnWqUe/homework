package ru.mpei.homework.service;

public interface DetailsService {

    //передача тока уставки
    void saveSetPoint(double e);

    //выдает вывод фаз, у которых КЗ
    String findFault(long startIndex, long endIndex);
}
