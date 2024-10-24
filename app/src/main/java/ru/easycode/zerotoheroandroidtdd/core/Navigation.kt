package ru.easycode.zerotoheroandroidtdd.core

import ru.easycode.zerotoheroandroidtdd.main.Screen

interface Navigation {
    interface Read : LiveDataWrapper.Read<Screen>
    interface Update : LiveDataWrapper.Update<Screen>
    interface Mutable : Read, Update

    class Base : LiveDataWrapper.AbstractLiveData<Screen>(), Mutable
}