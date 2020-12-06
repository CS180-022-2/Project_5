import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.*;

import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;

import static org.junit.Assert.fail;

public class RunLocalTest {
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

        //////////////////////////////////////////////////////////////////////////////////////////////
        // Test Cases for all classes
        ///////////////////////////////////////////////////////////////////////////////////////////////

        // AccountMenuFrame
        @Test(timeout = 1_000)
        public void accountMenuFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = AccountMenuFrame.class;
            className = "AccountMenuFrame";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `JOptionPane`!", JOptionPane.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements 'Runnable'", 1, superinterfaces.length);

        }
        @Test(timeout = 1_000)
        public void accountMenuFrameFieldDeclarationTest1() {
            Class<?> clazz;
            String className = "AccountMenuFrame";
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
            clazz = AccountMenuFrame.class;

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
        public void accountMenuFrameFieldDeclarationTest2() {
            Class<?> clazz;
            String className = "AccountMenuFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userId";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = AccountMenuFrame.class;

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
        public void accountMenuFrameFieldDeclarationTest3() {
            Class<?> clazz;
            String className = "AccountMenuFrame";
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
            clazz = AccountMenuFrame.class;

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
        public void accountMenuFrameFieldDeclarationTest4() {
            Class<?> clazz;
            String className = "AccountMenuFrame";
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
            clazz = AccountMenuFrame.class;

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
        public void accountMenuFrameFieldDeclarationTest5() {
            Class<?> clazz;
            String className = "AccountMenuFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "accountMenuFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;

            // Set the class being tested
            clazz = AccountMenuFrame.class;

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
        public void accountMenuFrameFieldDeclarationTest6() {
            Class<?> clazz;
            String className = "AccountMenuFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "editAccountButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = AccountMenuFrame.class;

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
        public void accountMenuFrameFieldDeclarationTest7() {
            Class<?> clazz;
            String className = "AccountMenuFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "deleteAccountButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = AccountMenuFrame.class;

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
        public void accountMenuFrameFieldDeclarationTest8() {
            Class<?> clazz;
            String className = "AccountMenuFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "backButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = AccountMenuFrame.class;

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
        public void accountMenuFrameFieldDeclarationTest9() {
            Class<?> clazz;
            String className = "AccountMenuFrame";
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
            clazz = AccountMenuFrame.class;

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
        public void accountMenuFrameParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "accountMenuFrame";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = AccountMenuFrame.class;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has one parameters with types Socket!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty `throws` clause!", expectedLength, exceptions.length);
        }
        ///////////////////////////////////////////////////////////////////////
        // exempt
        @Test(timeout = 1000)
        public void accountMenuFrameRunMethodTest() {
            Class<?> clazz;
            String className = "accountMenuFrame";
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
            clazz = AccountMenuFrame.class;

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
        /////////////////////////////////////////////////////////////////////////////
        // AccountProfileFrame
        @Test(timeout = 1_000)
        public void accountProfileFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = AccountProfileFrame.class;
            className = "AccountProfileFrame";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `JOptionPane`!", JOptionPane.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements 'Runnable'", 1, superinterfaces.length);

        }
        @Test(timeout = 1_000)
        public void accountProfileFrameFieldDeclarationTest1() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
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
            clazz = AccountProfileFrame.class;

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
        public void accountProfileFrameFieldDeclarationTest2() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userId";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = AccountProfileFrame.class;

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
        public void accountProfileFrameFieldDeclarationTest3() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
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
            clazz = AccountProfileFrame.class;

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
        public void accountProfileFrameFieldDeclarationTest4() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
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
            clazz = AccountProfileFrame.class;

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
        public void accountProfileFrameFieldDeclarationTest5() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "accountProfileFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;

            // Set the class being tested
            clazz = AccountProfileFrame.class;

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
        public void accountProfileFrameFieldDeclarationTest6() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "profileButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = AccountProfileFrame.class;

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
        public void accountProfileFrameFieldDeclarationTest7() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "accountButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = AccountProfileFrame.class;

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
        public void accountProfileFrameFieldDeclarationTest8() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "backButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = AccountProfileFrame.class;

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
        public void accountProfileFrameFieldDeclarationTest9() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
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
            clazz = AccountProfileFrame.class;

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
        public void accountProfileFrameParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = AccountProfileFrame.class;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has one parameters with types Socket!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty `throws` clause!", expectedLength, exceptions.length);
        }
        ///////////////////////////////////////////////////////////////////////
        // exempt
        @Test(timeout = 1000)
        public void accountProfileFrameRunMethodTest() {
            Class<?> clazz;
            String className = "AccountProfileFrame";
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
            clazz = AccountProfileFrame.class;

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
        ////////////////////////////////////////////////////////////////////////
        // AddFriendFrame
        @Test(timeout = 1_000)
        public void addFriendFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = AddFriendFrame.class;
            className = "AddFriendFrame";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `JPanel`!", JPanel.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements 'Runnable'", 1, superinterfaces.length);

        }
        @Test(timeout = 1_000)
        public void addFriendFrameFieldDeclarationTest1() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "columnName";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String[].class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void addFriendFrameFieldDeclarationTest2() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "addFriendFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest3() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "back";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest4() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "jScrollPane";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JScrollPane.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest5() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "jScrollPane2";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JScrollPane.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest6() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "jScrollPane2";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JScrollPane.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest7() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "panel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JPanel.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest8() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "accept";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JMenuItem.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest9() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "deny";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JMenuItem.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest10() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "allUserModel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = DefaultTableModel.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest11() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "requestModel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = DefaultTableModel.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest12() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "pendingModel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = DefaultTableModel.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest13() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "allUserTable";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTable.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest14() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "requestTable";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTable.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest15() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "pendingTable";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTable.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest16() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "rowSorter";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = TableRowSorter.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest17() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "jtfFilter";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest18() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "sendFriendRequest";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JMenuItem.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest19() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "viewProfile";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JMenuItem.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest20() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "resendRequest";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JMenuItem.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest21() {
            Class<?> clazz;
            String className = "AddFriendFrame";
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
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest22() {
            Class<?> clazz;
            String className = "AddFriendFrame";
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
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest23() {
            Class<?> clazz;
            String className = "AddFriendFrame";
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
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest24() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userId";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameFieldDeclarationTest25() {
            Class<?> clazz;
            String className = "AddFriendFrame";
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
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = AddFriendFrame.class;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has one parameters with types Socket!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty `throws` clause!", expectedLength, exceptions.length);
        }
        ///////////////////////////////////////////////////////////////////////
        // Exempt
        @Test(timeout = 1000)
        public void addFriendFrameRunMethodTest() {
            Class<?> clazz;
            String className = "AddFriendFrame";
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
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameUpdateAllUserModelMethodTest() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "updateAllUserModel";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = DefaultTableModel.class;


            // Set the class being tested
            clazz = AddFriendFrame.class;

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


            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` works correctly with proper input!", expectedLength, exceptions.length);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` fails with improper input!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void addFriendFrameUpdatePendingModelMethodTest() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "updatePendingModel";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = DefaultTableModel.class;


            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameUpdateRequestModelMethodTest() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "updateRequestModel";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = DefaultTableModel.class;


            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        public void addFriendFrameUpdateAllMethodTest() {
            Class<?> clazz;
            String className = "AddFriendFrame";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "updateAll";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = AddFriendFrame.class;

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
        ///////////////////////////////////////////////////////////////
        // EditAccountFrame
        @Test(timeout = 1_000)
        public void editAccountFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = EditAccountFrame.class;
            className = "EditAccountFrame";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `"+ className +"` extends `JOptionPane`!", JOptionPane.class, superclass);

            Assert.assertEquals("Ensure that `"+ className +"` implements 'Runnable'", 1, superinterfaces.length);

        }
        @Test(timeout = 1_000)
        public void editAccountFrameFieldDeclarationTest1() {
            Class<?> clazz;
            String className = "EditAccountFrame";
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
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest2() {
            Class<?> clazz;
            String className = "EditAccountFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userId";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest3() {
            Class<?> clazz;
            String className = "EditAccountFrame";
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
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest4() {
            Class<?> clazz;
            String className = "EditAccountFrame";
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
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest5() {
            Class<?> clazz;
            String className = "EditAccountFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "editAccountFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;

            // Set the class being tested
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest6() {
            Class<?> clazz;
            String className = "EditAccountFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "editAccountButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest7() {
            Class<?> clazz;
            String className = "EditAccountFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "backButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest8() {
            Class<?> clazz;
            String className = "EditAccountFrame";
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
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest9() {
            Class<?> clazz;
            String className = "EditAccountFrame";
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
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest10() {
            Class<?> clazz;
            String className = "EditAccountFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userIdTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest11() {
            Class<?> clazz;
            String className = "EditAccountFrame";
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
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest12() {
            Class<?> clazz;
            String className = "EditAccountFrame";
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
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest13() {
            Class<?> clazz;
            String className = "EditAccountFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "realNameLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest14() {
            Class<?> clazz;
            String className = "EditAccountFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "realNameTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest15() {
            Class<?> clazz;
            String className = "EditAccountFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameFieldDeclarationTest16() {
            Class<?> clazz;
            String className = "EditAccountFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "EditAccountFrame";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = EditAccountFrame.class;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has one parameters with types Socket!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty `throws` clause!", expectedLength, exceptions.length);
        }
        ///////////////////////////////////////////////////////////////////////
        @Test(timeout = 1000)
        public void editAccountFrameRunMethodTest() {
            Class<?> clazz;
            String className = "EditAccountFrame";
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
            clazz = EditAccountFrame.class;

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
        public void editAccountFrameContentCheckMethodTest() {
            Class<?> clazz;
            String className = "EditAccountFrame";
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


            // Set the class being tested
            clazz = EditAccountFrame.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class, String.class);
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
        /////////////////////////////////////////////////////////////////////////////
        // EditProfileFrame
        @Test(timeout = 1_000)
        public void editProfileFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = EditProfileFrame.class;
            className = "EditProfileFrame";

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
        public void editProfileFrameFieldDeclarationTest1() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest2() {
            Class<?> clazz;
            String className = "EditProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userId";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest3() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest4() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest5() {
            Class<?> clazz;
            String className = "EditProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "editProfileFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest6() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest7() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest8() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest9() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest10() {
            Class<?> clazz;
            String className = "EditProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "genderList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JComboBox.class;

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest11() {
            Class<?> clazz;
            String className = "EditProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "relationshipList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JComboBox.class;

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest12() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest13() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest14() {
            Class<?> clazz;
            String className = "EditProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "genderLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest15() {
            Class<?> clazz;
            String className = "EditProfileFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "relationshipLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest16() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest17() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest18() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest19() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameFieldDeclarationTest20() {
            Class<?> clazz;
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

            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "EditProfileFrame";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = EditProfileFrame.class;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has one parameters with types Socket!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty `throws` clause!", expectedLength, exceptions.length);
        }
        ///////////////////////////////////////////////////////////////////////
        @Test(timeout = 1000)
        public void editProfileFrameRunMethodTest() {
            Class<?> clazz;
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


            // Set the class being tested
            clazz = EditProfileFrame.class;

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
        public void editProfileFrameContentCheckMethodTest() {
            Class<?> clazz;
            String className = "EditProfileFrame";
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


            // Set the class being tested
            clazz = EditProfileFrame.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class, String.class, String.class, String.class, String.class);
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
        /////////////////////////////////////////////////////////////////////////////
        // Profile
        @Test(timeout = 1_000)
        public void profileClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = Profile.class;
            className = "Profile";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            //Assert.assertEquals("Ensure that `"+ className +"` extends `JComponent`!", JComponent.class, superclass);

            //Assert.assertEquals("Ensure that `"+ className +"` implements 'Runnable'", 1, superinterfaces.length);

        }
        @Test(timeout = 1_000)
        public void profileFieldDeclarationTest1() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "phoneNumber";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

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
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is  `private`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void profileFieldDeclarationTest2() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "relationship";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

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
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is  `private`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void profileFieldDeclarationTest3() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "gender";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

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
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is  `private`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void profileFieldDeclarationTest4() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "currentOccupation";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

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
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is  `private`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void profileFieldDeclarationTest5() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "interest";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

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
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is  `private`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void profileFieldDeclarationTest6() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "aboutMe";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

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
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is  `private`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        @Test(timeout = 1_000)
        public void profileParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "Profile";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = Profile.class;

            try {
                constructor = clazz.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has one parameters with types Socket!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty `throws` clause!", expectedLength, exceptions.length);
        }
        @Test(timeout = 1000)
        public void profileMethodTest1() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getPhoneNumber";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

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
        public void profileMethodTest2() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getRelationship";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

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
        public void profileMethodTest3() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getGender";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

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
        public void profileMethodTest4() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getCurrentOccupation";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

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
        public void profileMethodTest5() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getInterest";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

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
        public void profileMethodTest6() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getAboutMe";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

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
        public void profileMethodTest7() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setPhoneNumber";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Profile.class;

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

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileMethodTest8() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setRelationship";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Profile.class;

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

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileMethodTest9() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setGender";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Profile.class;

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

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileMethodTest10() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setCurrentOccupation";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Profile.class;

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

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileMethodTest11() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setInterest";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Profile.class;

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

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        @Test(timeout = 1000)
        public void profileMethodTest12() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setAboutMe";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Profile.class;

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

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        ///////////////////////////////////////////////////////////////////////////
        // ProfileDisplayFrame
        @Test(timeout = 1_000)
        public void profileDisplayFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;
            className = "ProfileDisplayFrame";

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
        public void profileDisplayFrameFieldDeclarationTest1() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
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
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest2() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "viewerId";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest3() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "profileOwnerId";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest4() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "tracker";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest5() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
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
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest6() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
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
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest7() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "profileDisplayFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest8() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userPhoneNoLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest9() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userPhoneNoTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest10() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "currentOccupationLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest11() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "currentOccupationTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest12() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "genderList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JComboBox.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest13() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "relationshipList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JComboBox.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest14() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "aboutMeLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest15() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "aboutMeTextField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest16() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "genderLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest17() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "relationshipLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest18() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "interestLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest19() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "interestField";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest20() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "backButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameFieldDeclarationTest21() {
            Class<?> clazz;
            String className = "ProfileDisplayFrame";
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
            clazz = ProfileDisplayFrame.class;

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
        public void profileDisplayFrameParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "LogProfileDisplayFrameinFrame";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = ProfileDisplayFrame.class;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class, String.class, String.class, String.class);
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
        public void profileDisplayFrameRunMethodTest() {
            Class<?> clazz;
            String className = "LoginProfileDisplayFrameFrame";
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
            clazz = ProfileDisplayFrame.class;

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
        //////////////////////////////////////////////////////////
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
        public void userIdFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userId";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

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
        // UserFrame
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
        public void userFrameFieldDeclarationTest4() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "columnName";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String[].class;

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
        public void userFrameFieldDeclarationTest5() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userId";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

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
        public void userFrameFieldDeclarationTest6() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "rowData";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String[][].class;

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
        public void userFrameFieldDeclarationTest7() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "model";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = DefaultTableModel.class;

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
        public void userFrameFieldDeclarationTest8() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "jTable";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTable.class;

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
        public void userFrameFieldDeclarationTest9() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userFrame";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JFrame.class;

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
        public void userFrameFieldDeclarationTest10() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "rowSorter";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = TableRowSorter.class;

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
        public void userFrameFieldDeclarationTest11() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "jtfFilter";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

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
        public void userFrameFieldDeclarationTest12() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "jScrollPane";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JScrollPane.class;

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
        public void userFrameFieldDeclarationTest13() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "add";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

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
        public void userFrameFieldDeclarationTest14() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "account";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

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
        public void userFrameFieldDeclarationTest15() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "back";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

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
        public void userFrameFieldDeclarationTest16() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "popupMenu";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JPopupMenu.class;

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
        public void userFrameFieldDeclarationTest17() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "viewProfile";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JMenuItem.class;

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
        public void userFrameFieldDeclarationTest18() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "deleteFriend";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JMenuItem.class;

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
        public void userFrameFieldDeclarationTest19() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "popupItemListener";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ActionListener.class;

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
        public void userFrameFieldDeclarationTest20() {
            Class<?> clazz;
            String className = "UserFrame";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "buttonActionListener";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ActionListener.class;

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
                constructor = clazz.getDeclaredConstructor(Socket.class, String.class);
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
        @Test(timeout = 1000)
        public void updateModelMethodTestUserFrame() {
            Class<?> clazz;
            String className = "UserFrame";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "updateModel";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = DefaultTableModel.class;


            // Set the class being tested
            clazz = UserFrame.class;

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

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        /////////////////////////////////////////////////////////////////////////////////////////
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

        @Test(timeout = 1000)
        public void ProfileClientMethodTestOne() {

            Class<?> clazz = ProfileClient.class;
            String className = "ProfileClient";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "main";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String[].class);
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

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

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

            Assert.assertEquals("Ensure that `"+ className +"` implements Serializable!", 1, superinterfaces.length);
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
        @Test(timeout = 1000)
        public void UserMethodTest9() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setRequestList";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ArrayList.class);
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
        public void UserMethodTest10() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setPendingList";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ArrayList.class);
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
        public void UserMethodTest11() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setUserId";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
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
        public void UserMethodTest12() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setPassword";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
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
        public void UserMethodTest13() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setName";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
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
        public void UserMethodTest14() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setEmail";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
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
        public void UserMethodTest15() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setUserProfile";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, Profile.class);
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
        public void UserMethodTest16() {

            Class<?> clazz = User.class;
            String className = "User";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setFriendList";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ArrayList.class);
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
            String methodName = "getProfile";

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
            String methodName = "requestFriend";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

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
        public void profileServerMethodTestSix() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "deleteFriend";

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
        public void profileServerMethodTestSeven() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "uniquePhoneNoCheck";

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
        @Test(timeout = 1000)
        public void profileServerMethodTest9() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "uniqueIdCheck";

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
        public void profileServerMethodTest10() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "acceptFriend";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

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
        public void profileServerMethodTest11() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "denyFriend";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

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
        public void profileServerMethodTest12() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "resendRequest";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

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
        public void profileServerMethodTest13() {

            Class<?> clazz = ProfileServer.class;
            String className = "ProfileServer";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "main";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String[].class);
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

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }
        ////////////////////////////////////////////////////////////////////////////////
        // CreateProfileFrame

        /////////////////////////////////////////////////////////////////////////////////////////
        // ProfileMenuFrame
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
            // Set the field that you want to tes
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
            String fieldName = "profileMenuFrame";

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
                constructor = clazz.getDeclaredConstructor(Socket.class, String.class);
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
        /////////////////////////////////////////////////////////////////////////////////////
        // Method Test Pass or Fail
        @Test
        public void methodPassFail() throws IOException {
            User derek = new User("derek", "Cs180===", "Derek Sun", "sun@purdue.edu");
            User leo = new User("leo", "Cs180===", "Leo li", "li@purdue.edu");
            User jason = new User("jason", "Cs180===", "Jason Hung", "hung@purdue.edu");
            User joshua = new User("joshua", "Cs180===", "Joshua Tree", "joshua@purdue.edu");
            User youngjun = new User("youngjun", "Cs180===", "Youngjun Yoo", "yoo@purdue.edu");
            ArrayList<User> friend = new ArrayList<User>();
            ArrayList<User> request = new ArrayList<User>();
            ArrayList<User> pending = new ArrayList<User>();
            friend.add(leo);
            request.add(jason);
            pending.add(youngjun);
            derek.setFriendList(friend);
            derek.setRequestList(request);
            derek.setPendingList(pending);

            Profile derekP = new Profile("12345678", "single", "male", "student", "ball", "student");
            derek.setUserProfile(derekP);
            Profile leoP = new Profile("", "", "", "", "", "");
            leo.setUserProfile(leoP);
            Profile jasonP = new Profile("", "", "", "", "", "");
            jason.setUserProfile(jasonP);
            Profile joshuaP = new Profile("", "", "", "", "", "");
            joshua.setUserProfile(joshuaP);
            Profile youngjunP = new Profile("", "", "", "", "", "");
            youngjun.setUserProfile(youngjunP);
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            // User   // Ensure '' works correctly
            String c = "User";
            String m = "getUserId";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "derek", derek.getUserId());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", "dereks", derek.getUserId());
            m = "getFriendList";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", friend, derek.getFriendList());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derek.getFriendList());
            m = "setFriendList";
            derek.setFriendList(friend);
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", friend, derek.getFriendList());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derek.getFriendList());
            m = "getPendingList";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", pending, derek.getPendingList());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derek.getPendingList());
            m = "setPendingList";
            derek.setPendingList(pending);
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", pending, derek.getPendingList());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derek.getPendingList());
            m = "getRequestList";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", request, derek.getRequestList());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derek.getRequestList());
            m = "setRequestList";
            derek.setRequestList(request);
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", request, derek.getRequestList());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derek.getRequestList());

            m = "getPassword";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "Cs180===", derek.getPassword());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", "Ds180===", derek.getPassword());
            m = "getName";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "Derek Sun", derek.getName());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", "Derek S", derek.getName());
            m = "getEmail";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "sun@purdue.edu", derek.getEmail());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", "@purdue.edu", derek.getEmail());
            m = "getUserProfile";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", derekP, derek.getUserProfile());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derek.getUserProfile());
            m = "setUserProfile";
            derek.setUserProfile(derekP);
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", derekP, derek.getUserProfile());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derek.getUserProfile());
            m = "setUserId";
            derek.setUserId("derek");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "derek", derek.getUserId());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", "dereks", derek.getUserId());
            m = "setPassword";
            derek.setPassword("Cs180===");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "Cs180===", derek.getPassword());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", "Ds180===", derek.getPassword());
            m = "setName";
            derek.setName("Derek Sun");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "Derek Sun", derek.getName());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", "Derek S", derek.getName());
            m = "setEmail";
            derek.setEmail("sun@purdue.edu");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "sun@purdue.edu", derek.getEmail());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", "@purdue.edu", derek.getEmail());
            //////////////////////////////////////////////////////////////////////////////////
            // Profile
            c = "Profile";
            m = "getPhoneNumber";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "12345678", derekP.getPhoneNumber());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getPhoneNumber());
            m = "setPhoneNumber";
            derekP.setPhoneNumber("");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "", derekP.getPhoneNumber());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getPhoneNumber());
            m = "getRelationship";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "single", derekP.getRelationship());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getRelationship());
            m = "setRelationship";
            derekP.setRelationship("");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "", derekP.getRelationship());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getRelationship());
            m = "getGender";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "male", derekP.getGender());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getGender());
            m = "setGender";
            derekP.setGender("");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "", derekP.getGender());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getGender());
            m = "getCurrentOccupation";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "student", derekP.getCurrentOccupation());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getCurrentOccupation());
            m = "setCurrentOccupation";
            derekP.setCurrentOccupation("");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "", derekP.getCurrentOccupation());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getCurrentOccupation());
            m = "getInterest";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "ball", derekP.getInterest());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getGender());
            m = "setInterest";
            derekP.setInterest("");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "", derekP.getInterest());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getInterest());
            m = "getAboutMe";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "student", derekP.getAboutMe());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getAboutMe());
            m = "setAboutMe";
            derekP.setAboutMe("");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "", derekP.getAboutMe());
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", null, derekP.getAboutMe());
            //////////////////////////////////////////////////////////////////////////////////
            // Register Frame
            c = "RegisterFrame";
            m = "contentCheck";
            Socket socket = new Socket("localhost", 1112);
            RegisterFrame rf = new RegisterFrame(socket);
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", true, rf.contentCheck(derek.getUserId(), derek.getPassword()
                    ,derek.getName(), derek.getEmail()));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, rf.contentCheck(".+", "Cs180===", "Derek Sun", "sun@purdue.edu"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, rf.contentCheck("derek", "", "Derek Sun", derek.getEmail()));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, rf.contentCheck("derek", "Cs180===", "Derek S", "sun@purdue.edu"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, rf.contentCheck("derek", "Cs180===", "Derek Sun", ""));
            //////////////////////////////////////////////////////////////////////////////////
            // EditAccountFrame
            c = "EditAccountFrame";
            EditAccountFrame eaf = new EditAccountFrame(socket, "derek2");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", true, eaf.contentCheck("Cs180==="
                    ,"Derek Sun", "sun@purdue.edu"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, eaf.contentCheck("", "Derek Sun", "sun@purdue.edu"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, eaf.contentCheck("", "Derek Sun", ""));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, eaf.contentCheck("Cs180===", "Derek S", "sun@purdue.edu"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, eaf.contentCheck("Cs180===", "Derek Sun", ""));

            // EditProfileFrame
            c = "EditProfileFrame";
            EditProfileFrame ep = new EditProfileFrame(socket, "derek2");
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", true, ep.contentCheck("1111111111", "student", "hi"
                    , "student", "male", "single"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ep.contentCheck("", "student", "hi"
                    , "student", "male", "single"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ep.contentCheck("1111111111", "", "hi"
                    , "student", "male", "single"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ep.contentCheck("1111111111", "student", ""
                    , "student", "male", "single"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ep.contentCheck("1111111111", "student", "hi"
                    , "", "male", "single"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ep.contentCheck("1111111111", "student", "hi"
                    , "", "", "single"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ep.contentCheck("1111111111", "student", "hi"
                    , "", "male", ""));
            // ProfileServer
            ProfileServer ps = new ProfileServer(socket);
            String[] hi = new String[]{};
            try {
                ps.main(hi);
            } catch (Exception e) {
                e.printStackTrace();
            }
            c = "ProfileServer";
            m = "login";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.login("derek2", "Cs180==="));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.login("dere", "Cs180==="));
            /*m = "dualLoginCheck";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.dualLoginCheck("derek2"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", false, ps.dualLoginCheck("dere"));*/
            m = "getProfile";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", ps.getProfile("derek2"), ps.getProfile("derek2"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.getProfile("dere"));
            m = "setUserProfile";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.setUserProfile(derekP, "derek2"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.setUserProfile(joshuaP, ""));
            m = "requestFriend";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "Already requested!", ps.requestFriend("derek2", "jason"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.requestFriend("dere", ""));
            m = "deleteFriend";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.deleteFriend("derek2", "leo"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.deleteFriend("d", ""));
            m = "uniquePhoneNoCheck";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.uniquePhoneNoCheck("12345678"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.uniquePhoneNoCheck(""));
            m = "uniqueIdCheck";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.uniqueIdCheck("xdwx"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.uniqueIdCheck("derek2"));
            m = "acceptFriend";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "AcceptSuccess", ps.acceptFriend("jason", "derek2"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.acceptFriend("", ""));
            m = "denyFriend";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "DenySuccess", ps.denyFriend("joshua", "derek2"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.denyFriend("", ""));
            m = "resendRequest";
            Assert.assertEquals("Ensure " + c + "'s method " + m + " works correctly", "ResendSuccess", ps.resendRequest("derek2", "joshua"));
            Assert.assertNotEquals("Ensure " + c + "'s method " + m + " works correctly", true, ps.resendRequest("", ""));

        }
    }
}
