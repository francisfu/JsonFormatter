package biye.fu.util.jsonformatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by npufr on 2017/8/13.
 */
@Controller
@SpringBootApplication
public class SampleController {

    @RequestMapping("/hello")
    String home(){
        return "Hello World";
    }

    @RequestMapping(path = "/format",method = RequestMethod.POST)
    @ResponseBody
    String format(@RequestParam("input") String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Object object = mapper.readValue(json, Object.class);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
}
