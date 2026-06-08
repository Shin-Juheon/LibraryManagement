import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryMainTest {

    @Test
    void adminAccountLock() {

        Map<String, Integer> failCountMap = new HashMap<>();
        Map<String, Long> lockTimeMap = new HashMap<>();

        String id = "admin";

        for(int i = 0; i < 5; i++) {

            int failCount =
                    failCountMap.getOrDefault(id, 0) + 1;

            failCountMap.put(id, failCount);

            if(failCount >= 5) {

                long lockDuration = 10 * 60 * 1000;

                lockTimeMap.put(
                        id,
                        System.currentTimeMillis() + lockDuration
                );
            }
        }
        assertTrue(lockTimeMap.containsKey("admin"));
    }
    @Test
    void userAccountLock() {

        Map<String, Integer> failCountMap = new HashMap<>();
        Map<String, Long> lockTimeMap = new HashMap<>();

        String id = "user01";

        for(int i = 0; i < 5; i++) {

            int failCount =
                    failCountMap.getOrDefault(id, 0) + 1;

            failCountMap.put(id, failCount);

            if(failCount >= 5) {

                long lockDuration = 3 * 60 * 1000;

                lockTimeMap.put(
                        id,
                        System.currentTimeMillis() + lockDuration
                );
            }
        }
        assertTrue(lockTimeMap.containsKey("user01"));
    }
}