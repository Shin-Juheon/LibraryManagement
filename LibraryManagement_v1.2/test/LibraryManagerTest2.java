// 원래 있던 LibraryManagerTest에 checkServerStatus에 대한 테스트 코드가 있어 중복되지 않게 새로운 테스트 파일 생성
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerTest {

    private final LibraryManager manager =
            new LibraryManager(
                    new LibraryRepository());

    @Test
    void 정상_IP_검사() {

        assertTrue(
                manager.isValidIp(
                        "127.0.0.1"));
    }
}
