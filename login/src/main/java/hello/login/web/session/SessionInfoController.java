package hello.login.web.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Slf4j
@RestController
public class SessionInfoController {

    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null) {
            return "세션이 존재하지 않습니다.";
        }


        session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("session name={}, value={}", name, session.getAttribute(name)) );


        log.info("sessionId={}", session.getId()); // 세션 id
        log.info("maxInactiveInterval={}", session.getMaxInactiveInterval()); // 유효시간
        log.info("creationTime={}", new Date(session.getCreationTime())); // 생성날짜
        log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime())); // 최근 서버 접근 시간
        log.info("isNew={}", session.isNew());

        return "세션 출력";
    }
}
