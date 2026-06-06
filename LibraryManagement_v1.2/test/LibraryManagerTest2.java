/**
 * 원래 있던 LibraryManagerTest에 checkServerStatus에 대한 테스트 코드가 있어 중복되지 않게 새로운 테스트 파일 생성
 * isValidIp에 대한 테스트 코드입니다.
 * @see LibraryManager#isValidIp(java.lang.String)
 * @see <a href="https://github.com/Shin-Juheon/LibraryManagement/issues/8">
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerTest2 {

    private final LibraryManager manager =
            new LibraryManager(
                    new LibraryRepository());

    @Test
    void correctIpTest() {

        assertTrue(
                manager.isValidIp(
                        "127.0.0.1"));
    }
    @Test
    void commandInjectionTest() {

        assertFalse(
                manager.isValidIp(
                        "127.0.0.1 && whoami")
        );
    }

    @Test
    void commandInjectionTest2() {

        assertFalse(
                manager.isValidIp(
                        "127.0.0.1 & dir")
        );
    }

    @Test
    void commandInjectionTest3() {

        assertFalse(
                manager.isValidIp(
                        "abc.def.ghi.jkl")
        );
    }
}