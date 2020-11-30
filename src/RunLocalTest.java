import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.*;

import java.net.Socket;
import java.util.ArrayList;

import static org.junit.Assert.fail;

public class  RunLocalTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }

    /**
     * A set of public test cases.
     *
     * <p>Purdue University -- CS18000 -- Fall 2020</p>
     *
     * @author Purdue CS
     * @version August 24, 2020
     */

    public static class TestCase {
        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }

        // Login Frame
        @Test(timeout = 1_000)
        public void loginFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = LoginFrame.class;
            className = "LoginFrame";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `JComponent`!", JComponent.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements 'Runnable'", 1, superinterfaces.length);

        }

        @Test(timeout = 1_000)
        public void loginFrameFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "loginFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void userIdLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userIdLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void userIdFieldFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userIdField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void passwordLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "passwordLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void passwordFieldFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "passwordField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JPasswordField.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void loginButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "loginButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void registerButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "registerButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void socketFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "socket";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Socket.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void bufferedReaderFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "bufferedReader";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = BufferedReader.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void printWriterFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "printWriter";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = PrintWriter.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void actionListenerFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "actionListener";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ActionListener.class;

            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void LoginFrameParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = LoginFrame.class;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has one parameters with types Socket!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty `throws` clause!", expectedLength, exceptions.length);
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////
        @Test(timeout = 1000)
        public void runMethodTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "run";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = LoginFrame.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////
        // RegisterFrame
        @Test(timeout = 1_000)
        public void RegisterFrameClassDeclarationTest() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends 'JComponent'", JComponent.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements 'Runnable'!", 1, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestOne() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "registerFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestTwo() {
            Class<?> clazz;
            String className = "RegisterFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "socket";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Socket.class;

            // Set the class being tested
            clazz = RegisterFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestThree() {
            Class<?> clazz;
            String className = "RegisterFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "bufferedReader";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = BufferedReader.class;

            // Set the class being tested
            clazz = RegisterFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestFour() {
            Class<?> clazz;
            String className = "RegisterFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "printWriter";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = PrintWriter.class;

            // Set the class being tested
            clazz = RegisterFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestFive() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userIdLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestSix() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userIdTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestSeven() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "passwordField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JPasswordField.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestEight() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "realNameLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestNine() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "realNameTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestTen() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestEleven() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestTwelve() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "registerButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestThirteen() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "backButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameFieldDeclarationTestFourteen() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "passwordLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void actionListenerFieldDeclarationTestRegisterFrame() {
            Class<?> clazz;
            String className = "RegisterFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "actionListener";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ActionListener.class;

            // Set the class being tested
            clazz = RegisterFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void RegisterFrameParameterizedConstructorDeclarationTest() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 2;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has three parameters with type String, String, and double!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            //Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an two `throws` clauses!", expectedLength, exceptions.length);
        }
        ///////////////////////////////////////////////////////////////////////////////////////
        @Test(timeout = 1000)
        public void runMethodTestRegisterFrame() {
            Class<?> clazz;
            String className = "RegisterFrame";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "run";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = RegisterFrame.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void RegisterFrameMethodTestOne() {

            Class<?> clazz = RegisterFrame.class;
            String className = "RegisterFrame";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "contentCheck";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // User Frame
        @Test(timeout = 1_000)
        public void UserFrameClassDeclarationTest() {

            Class<?> clazz = UserFrame.class;
            String className = "UserFrame";

            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `JComponent`!", JComponent.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements Runnable!", 1, superinterfaces.length);
        }
        @Test(timeout = 1_000)
        public void socketFieldDeclarationTestUserFrame() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "socket";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Socket.class;

            // Set the class being tested
            clazz = UserFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void bufferedReaderFieldDeclarationTestUserFrame() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "bufferedReader";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = BufferedReader.class;

            // Set the class being tested
            clazz = UserFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void printWriterFieldDeclarationTestUserFrame() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "printWriter";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = PrintWriter.class;

            // Set the class being tested
            clazz = UserFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void UserFrameParameterizedConstructorDeclarationTest() {

            Class<?> clazz = UserFrame.class;
            String className = "UserFrame";

            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 2;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has two parameters with types String and String!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            //Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an two `throws` clauses!", expectedLength, exceptions.length);
        }
        /////////////////////////////////////////////////////////////////////////////////////////
        @Test(timeout = 1000)
        public void runMethodTestUserFrame() {
            Class<?> clazz;
            String className = "UserFrame";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "run";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = UserFrame.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        /////////////////////////////////////////////////////////////////////////////////////////
/*
        @Test(timeout = 1_000)
        public void invalidStudentExceptionClassDeclarationTest() {

            Class<?> clazz = InvalidStudentException.class;
            String className = "InvalidStudentException";

            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;


            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `Exception`!", Exception.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements 0 interface!", 0, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void invalidStudentExceptionConstructorDeclarationTest() {

            Class<?> clazz = InvalidStudentException.class;
            String className = "InvalidStudentException";

            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            try {
                constructor = clazz.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has no parameters!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty`throws` clauses!", expectedLength, exceptions.length);
        }

        @Test(timeout = 1_000)
        public void invalidStudentExceptionParameterizedConstructorDeclarationTest() {

            Class<?> clazz = InvalidStudentException.class;
            String className = "InvalidStudentException";

            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            try {
                constructor = clazz.getDeclaredConstructor(String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has one parameters of type String!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty`throws` clauses!", expectedLength, exceptions.length);
        }


        @Test(timeout = 1_000)
        public void leasableClassDeclarationTest() {

            Class<?> clazz = Leasable.class;
            String className = "Leasable";

            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;


            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `"+ className +"` is an `interface`!", Modifier.isInterface(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` implements 0 interface!", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void leasableMethodTestOne() {

            Class<?> clazz = Leasable.class;
            String className = "Leasable";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "countResidents";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = int.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void leasableMethodTestTwo() {

            Class<?> clazz = Leasable.class;
            String className = "Leasable";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getContractCost";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = double.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void leasableMethodTestThree() {

            Class<?> clazz = Leasable.class;
            String className = "Leasable";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "signContract";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ProfileServer.class, int.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has two parameters of types ProfileServer and int!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        //@ScoringWeight(1)
        public void leasableMethodTestFour() {

            Class<?> clazz = Leasable.class;
            String className = "Leasable";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "signContract";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = int.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ProfileServer.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type ProfileServer!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void leasableMethodTestFive() {

            Class<?> clazz = Leasable.class;
            String className = "Leasable";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "viewResident";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = ProfileServer.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, int.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type int!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void leasableMethodTestSix() {

            Class<?> clazz = Leasable.class;
            String className = "Leasable";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "countFloormates";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = int.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, int.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type int!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void leasableMethodTestSeven() {

            Class<?> clazz = Leasable.class;
            String className = "Leasable";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "listResidents";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = ArrayList.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void leasableMethodTestEight() {

            Class<?> clazz = Leasable.class;
            String className = "Leasable";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "cancelContract";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = int.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type String!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void leasableMethodTestNine() {

            Class<?> clazz = Leasable.class;
            String className = "Leasable";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "saveResidentInfoToFile";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type String!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }


        @Test(timeout = 1_000)
        public void occupiedRoomExceptionClassDeclarationTest() {

            Class<?> clazz = OccupiedRoomException.class;
            String className = "OccupiedRoomException";

            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `Exception`!", Exception.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements 0 interface!", 0, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void occupiedRoomExceptionConstructorDeclarationTestOne() {

            Class<?> clazz = OccupiedRoomException.class;
            String className = "OccupiedRoomException";

            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            try {
                constructor = clazz.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has no parameters!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty`throws` clauses!", expectedLength, exceptions.length);
        }

        @Test(timeout = 1_000)
        public void occupiedRoomExceptionParameterizedConstructorDeclarationTestOne() {

            Class<?> clazz = OccupiedRoomException.class;
            String className = "OccupiedRoomException";

            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            try {
                constructor = clazz.getDeclaredConstructor(String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has one parameters of type String!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty`throws` clauses!", expectedLength, exceptions.length);
        }
*/
        // ProfileClient
        @Test(timeout = 1_000)
        public void ProfileClientClassDeclarationTest() {

            Class<?> clazz = ProfileClient.class;
            String className = "ProfileClient";

            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `Object`!", Object.class, superclass);

            //Assert.assertEquals("Ensure that `"+ className +"` implements 1 interface!", 1, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void ProfileClientFieldDeclarationTestOne() {

            Class<?> clazz = ProfileClient.class;
            String className = "ProfileClient";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "socket";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Socket.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        //////////////////////////////////////////////////////////////////////////////////
        // User
        @Test(timeout = 1_000)
        public void UserClassDeclarationTest() {

            Class<?> clazz = User.class;
            String className = "User";

            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces!", 0, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void UserFieldDeclarationTestOne() {

            Class<?> clazz = User.class;
            String className = "User";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userId";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void UserFieldDeclarationTestTwo() {

            Class<?> clazz = User.class;
            String className = "User";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "name";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void UserFieldDeclarationTestThree() {

            Class<?> clazz = User.class;
            String className = "User";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "email";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void UserFieldDeclarationTestFour() {

            Class<?> clazz = User.class;
            String className = "User";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "password";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void UserFieldDeclarationTestFive() {

            Class<?> clazz = User.class;
            String className = "User";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "friendList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ArrayList.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void UserFieldDeclarationTestSix() {

            Class<?> clazz = User.class;
            String className = "User";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "requestList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ArrayList.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void UserFieldDeclarationTestSeven() {

            Class<?> clazz = User.class;
            String className = "User";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "pendingList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ArrayList.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void UserFieldDeclarationTestEight() {

            Class<?> clazz = User.class;
            String className = "User";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userProfile";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Profile.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void UserParameterizedConstructorDeclarationTest() {

            Class<?> clazz = User.class;
            String className = "User";

            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 2;

            try {
                constructor = clazz.getDeclaredConstructor(String.class, String.class, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has two parameters of type String and String!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            //Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an two `throws` clauses!", expectedLength, exceptions.length);
        }
        ///////////////////////////////////////////////////////////////////
        @Test(timeout = 1000)
        public void methodTestOne() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getRequestList";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = ArrayList.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void UserMethodTestTwo() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getPendingList";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = ArrayList.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void UserMethodTestThree() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getUserId";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has two parameters with types ProfileServer and int!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            //Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an one `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void UserMethodTestFour() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getPassword";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter with type ProfileServer!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            //Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an one `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void UserMethodTestFive() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getName";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter with type ProfileServer!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            //Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an one `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void UserMethodTestSix() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getEmail";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter with type ProfileServer!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            //Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an one `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void UserMethodTestSeven() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getFriendList";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = ArrayList.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter with type ProfileServer!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            //Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an one `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void UserMethodTestEight() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getUserProfile";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter with type ProfileServer!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            //Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an one `throws` clause!", expectedLength, exceptions.length);

        }
        ////////////////////////////////////////////////////////////////////////////////
        // ProfileServer
        @Test(timeout = 1_000)
        public void profileServerClassDeclarationTest() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements Runnable!", 1, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void profileServerFieldDeclarationTestOne() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "socket";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Socket.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileServerFieldDeclarationTestTwo() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userArrayList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ArrayList.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `public`!", Modifier.isPublic(modifiers));

            //Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileServerParameterizedConstructorDeclarationTestOne() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has five parameters of types String, String, String, int, and LoginFrame!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty`throws` clauses!", expectedLength, exceptions.length);
        }
        /////////////////////////////////////////////////////////////////////////////////////
        @Test(timeout = 1000)
        public void profileServerMethodTestOne() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "dualLoginCheck";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `Synchronized`!", Modifier.isSynchronized(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileServerMethodTestTwo() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "login";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `Synchronized`!", Modifier.isSynchronized(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileServerMethodTestThree() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "register";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `Synchronized`!", Modifier.isSynchronized(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileServerMethodTestFour() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setUserProfile";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, Profile.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `Synchronized`!", Modifier.isSynchronized(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileServerMethodTestFive() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "viewProfile";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `Synchronized`!", Modifier.isSynchronized(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileServerMethodTestSix() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "addFriend";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `Synchronized`!", Modifier.isSynchronized(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileServerMethodTestSeven() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "checkFriendRequest";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `Synchronized`!", Modifier.isSynchronized(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileServerMethodTestEight() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "run";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `Public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        ////////////////////////////////////////////////////////////////////////////////
        // CreateProfileFrame
        @Test(timeout = 1_000)
        public void createProfileFrameClassDeclarationTest() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `JComponent`!", JComponent.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements Runnable!", 1, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTestOne() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "socket";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Socket.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTestTwo() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "bufferedReader";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = BufferedReader.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTestThree() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "printWriter";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = PrintWriter.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTestFour() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "profileFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTestFive() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userPhoneNoLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTestOSix() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userPhoneNoTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTestSeven() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "currentOccupationLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTestEight() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "currentOccupationTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTestNine() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "genderChoose";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String[].class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTestTen() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "genderList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JList.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest11() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "relationshipChoose";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String[].class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest12() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "relationshipList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JList.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest13() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "aboutMeLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest14() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "aboutMeTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest15() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "gender";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest16() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "relationship";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest17() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "interestLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest18() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "interestField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest19() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "createProfileButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest20() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "editProfileButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest21() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "deleteProfileButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest22() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "backButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameFieldDeclarationTest23() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "actionListener";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ActionListener.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void createProfileFrameParameterizedConstructorDeclarationTestOne() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has five parameters of types String, String, String, int, and LoginFrame!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty`throws` clauses!", expectedLength, exceptions.length);
        }
        /////////////////////////////////////////////////////////////////////////////////////
        @Test(timeout = 1000)
        public void createProfileFrameMethodTestOne() {

            Class<?> clazz = EditProfileFrame.class;
            String className = "EditProfileFrame";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "run";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `Public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        /////////////////////////////////////////////////////////////////////////////////////////
        // MenuFrame
        @Test(timeout = 1_000)
        public void menuFrameFrameClassDeclarationTest() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `JComponent`!", JComponent.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements Runnable!", 1, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void menuFrameFieldDeclarationTestOne() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "socket";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Socket.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void menuFrameFieldDeclarationTest2() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "bufferedReader";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = BufferedReader.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void menuFrameFieldDeclarationTest3() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "printWriter";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = PrintWriter.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void menuFrameFieldDeclarationTest4() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "MenuFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void menuFrameFieldDeclarationTest5() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "createProfileButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void menuFrameFieldDeclarationTest6() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "editProfileButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void menuFrameFieldDeclarationTest7() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "deleteProfileButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void menuFrameFieldDeclarationTest8() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "backButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void menuFrameFieldDeclarationTest9() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "actionListener";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ActionListener.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            //Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void menuFrameParameterizedConstructorDeclarationTestOne() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has five parameters of types String, String, String, int, and LoginFrame!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty`throws` clauses!", expectedLength, exceptions.length);
        }
        /////////////////////////////////////////////////////////////////////////////////////
        @Test(timeout = 1000)
        public void menuFrameMethodTestOne() {

            Class<?> clazz = ProfileMenuFrame.class;
            String className = "ProfileMenuFrame";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "run";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `Public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
    }
}
