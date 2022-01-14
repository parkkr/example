package develop.example.external;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExternalServiceNonTransactional {


    public void getExResourceWithRequired(){
        throw new RuntimeException("강제예외발생중 getExResourceWithRequired RuntimeException");
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public void getExResourceWithRequiresNew(){
        throw new RuntimeException("강제예외발생중 getExResourceWithRequiresNew RuntimeException");
    }

    public void getExResourceWithRequiredTryCatch(){

        try{
            throw new RuntimeException("강제예외발생중 getExResourceWithRequiredTryCatch RuntimeException");
        }catch(Exception e){
            System.out.println("### getExResourceWithRequiresNew e.getMessage ::: " + e.getMessage());

        }
    }


    public void getExResourceWithRequiredFallback(){
        
        //TODO fallback메소드 구현법 찾아보기
        //throw new RuntimeException("강제예외발생중 getExResourceWithRequiredFallback RuntimeException");
    }


    @Transactional(readOnly = true, noRollbackFor = RuntimeException.class)
    public void getExResourceWithRequiredNoRollbackFor(){
        throw new RuntimeException("강제예외발생중 getExResourceWithRequiredNoRollbackFor RuntimeException");
    }


    @Transactional(readOnly = true, noRollbackFor = RuntimeException.class)
    public void getExResourceWithRequiredNoRollbackForTryCatch(){

        try{
            throw new RuntimeException("강제예외발생중 getExResourceWithRequiredNoRollbackForTryCatch RuntimeException");
        }catch(Exception e){
            System.out.println("### getExResourceWithRequiredNoRollbackForTryCatch e.getMessage ::: " + e.getMessage());

        }

    }


}
