package org.grakovne.file.storage.utils;

import org.grakovne.file.storage.exception.FileStorageException;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EncryptionUtils {

    public static String getFileHash(File file) {
        try {
            return DigestUtils.md5DigestAsHex(new FileInputStream(file));
        } catch (IOException e) {
            throw new FileStorageException("Can't hash file.");
        }
    }
}
