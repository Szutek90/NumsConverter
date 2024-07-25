package com.app.file_operator;

import java.util.List;

public interface FileOperator<T> {
    void writeFile(List<T> data);
}
