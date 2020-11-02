package ru;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) {
            File classFile = new File(name + ".class");
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(classFile))) {
                byte[] content = new byte[(int) classFile.length()];
                bis.read(content);
                final Class<?> someClass = defineClass(name, content, 0, content.length);
                return someClass;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
}
