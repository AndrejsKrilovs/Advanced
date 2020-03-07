package sda.tasks.exceptions;

import sda.tasks.exceptions.misc.ExecutableForThrow;
import sda.tasks.exceptions.misc.ThrowNotImplementedException;
import sda.tasks.exceptions.misc.Utils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.io.NotActiveException;

public class JuniorDeveloperSenior {

    /**
     * throw runtimeException with message "Hello Exception"
     */
    public void throwRuntimeExceptionWithMessage() {
        throw new RuntimeException("Hello Exception");
    }

    /**
     * Call static Utils.methodThatWillFail
     * catch exception it throws. Get the message.
     * throw RuntimeException with same message
     */
    public void rethrowException() throws IOException {
        Utils.methodThatWillFail();
    }

    /**
     * Return -1 if exceptions happens, otherWise return input paramether + 5 (Integer)
     */
    public Integer throwOrReturnPlus5(String someInt) {
        try {
            return Integer.parseInt(someInt) + 5;
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    /**
     * Create Exception that extends Runtime exception and throw
     * it with message "Hello"
     * 1) Create new Class Extends RuntimeException
     * 2) Throw it
     */
    public void throwCustomException() {
        throw new MyException("Hello");
    }

    private static class MyException extends RuntimeException {
        private String source;

        public MyException(String source) {
            this.source = source;
        }

        @Override
        public String getMessage() {
            return source;
        }
    }

    /**
     * return -1 if NotImplementedException Happens
     * return -2 if IOexception happens
     * Start with:: executableForThrow.execute()
     */
    public Integer returnValueDependOnException(ExecutableForThrow executableForThrow) throws IOException {
        try {
            executableForThrow.execute();
            return 0;
        } catch (ExceptionInInitializerError e) {
            return -1;
        } catch (IOException iex) {
            return -2;
        }
    }
}
