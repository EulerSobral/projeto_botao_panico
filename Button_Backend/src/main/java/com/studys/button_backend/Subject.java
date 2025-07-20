package com.studys.button_backend;

interface Subject{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
}