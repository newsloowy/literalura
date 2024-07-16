package me.sloowy.literalura.services;

public interface IDataConverter {

    <T> T convertData(String json, Class<T> className);
}
