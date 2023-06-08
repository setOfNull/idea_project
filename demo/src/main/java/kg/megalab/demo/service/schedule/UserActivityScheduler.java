package kg.megalab.demo.service.schedule;


import kg.megalab.demo.dal.entity.IdeaEntity;
import kg.megalab.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserActivityScheduler {

    private UserService userService;
private IdeaEntity idea;
    @Scheduled(cron = "*/15 * * * * *")
    public void checkLastUserActivity(){
        if (idea.getIsActual()){
            idea.setIsActual(false);
        }
     log.info("Scheduler worked");

    }

}


//получается все query в репозитории
//а дальше мы вызываем это все через сервис здесь