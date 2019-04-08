package com.cjs.nioTest.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * @author chen.jinshu (青禾)
 * 2019/04/08
 */
public class FileOperatorUtil {

    private static final String DEFAULT_FILE_PERMISSIONS = "rw-rw-rw-";

    private static final char SYSTEM_PATH_SEPARATOR = File.separatorChar;

    /**
     * 创建文件(采用默认文件权限)
     * @param filepath 文件路径
     * @throws IOException IOException
     */
    public static void createFile(String filepath) throws IOException {
        createFile(filepath, DEFAULT_FILE_PERMISSIONS);
    }

    /**
     * 创建文件(采用指定文件权限)
     * @param filepath 文件路径
     * @param permissions 文件权限属性
     * @throws IOException IOException
     */
    public static void createFile(String filepath, String permissions) throws IOException {
        Path path = Paths.get(filepath);
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(permissions);
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        Files.createFile(path, attr);
    }

    /**
     * 删除文件
     * @param filepath 文件路径
     * @throws IOException IOException
     */
    public static void deleteFile(String filepath) throws IOException {
        Path path = Paths.get(filepath);
        Files.deleteIfExists(path);
    }

    /**
     * 拷贝文件(默认文件覆盖和属性拷贝)
     * @param sourceFilepath 文件源路径
     * @param targetFilePath 文件目标路径
     * @throws IOException IOException
     */
    public static void copyFile(String sourceFilepath, String targetFilePath) throws IOException {
        copyFile(sourceFilepath, targetFilePath, true);
    }

    /**
     * 拷贝文件(可设置是否进行文件覆盖)
     * @param sourceFilepath 文件源路径
     * @param targetFilePath 文件目标路径
     * @param replace 是否进行文件覆盖
     * @throws IOException IOException
     */
    public static void copyFile(String sourceFilepath, String targetFilePath, boolean replace) throws IOException {
        Path source = Paths.get(sourceFilepath);

        if (targetFilePath.charAt(targetFilePath.length() - 1) == SYSTEM_PATH_SEPARATOR) {
            // 目标路径是一个目录, 直接采用原始文件名
            String filename = sourceFilepath.substring(sourceFilepath.lastIndexOf(SYSTEM_PATH_SEPARATOR) + 1);
            targetFilePath += filename;
        }

        Path target = Paths.get(targetFilePath);

        if (replace) {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
        } else {
            if (Files.exists(target)) {
                System.out.println("<<<<<<<<<<<<<< 拷贝失败,文件" + targetFilePath + "已存在 <<<<<<<<<<<<");
            } else {
                Files.copy(source, target, StandardCopyOption.COPY_ATTRIBUTES);
            }
        }
    }

    /**
     * 移动文件(默认文件覆盖和原子移动)
     * @param sourceFilepath 文件源路径
     * @param targetFilePath 文件目标路径
     * @throws IOException IOException
     */
    public static void moveFile(String sourceFilepath, String targetFilePath) throws IOException {
        moveFile(sourceFilepath, targetFilePath, true);
    }

    /**
     * 移动文件(可设置是否进行文件覆盖)
     * @param sourceFilepath 文件源路径
     * @param targetFilePath 文件目标路径
     * @param replace 是否进行文件覆盖
     * @throws IOException IOException
     */
    public static void moveFile(String sourceFilepath, String targetFilePath, boolean replace) throws IOException {
        Path source = Paths.get(sourceFilepath);

        if (targetFilePath.charAt(targetFilePath.length() - 1) == SYSTEM_PATH_SEPARATOR) {
            // 目标路径是一个目录, 直接采用原始文件名
            String filename = sourceFilepath.substring(sourceFilepath.lastIndexOf(SYSTEM_PATH_SEPARATOR) + 1);
            targetFilePath += filename;
        }

        Path target = Paths.get(targetFilePath);

        if (replace) {
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        } else {
            if (Files.exists(target)) {
                System.out.println("<<<<<<<<<<<<<< 移动失败,文件" + targetFilePath + "已存在 <<<<<<<<<<<<");
            } else {
                Files.move(source, target, StandardCopyOption.ATOMIC_MOVE);
            }
        }
    }
}
