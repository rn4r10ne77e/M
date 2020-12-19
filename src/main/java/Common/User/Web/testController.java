package Common.User.Web;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class testController {

	@RequestMapping(value="/testUpload")
	@ResponseBody
	public String upload( @RequestParam(value="testData") String testData, MultipartHttpServletRequest request ) throws IOException {
		System.out.println( "called "+ testData );

		MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest)request;
		Iterator<String> fileIter = mptRequest.getFileNames();
		
		while (fileIter.hasNext()) {
			String tempFileName = (String)fileIter.next();
			MultipartFile mFile = mptRequest.getFile(tempFileName);
			
			
			String mimeType = new Tika().detect(mFile.getInputStream());
			System.out.println( mimeType );
			/*
			Metadata metadata = new Metadata();
			Parser parser = new AutoDetectParser();
			ParseContext pc = new ParseContext();
			
			metadata.set(Metadata.RESOURCE_NAME_KEY, mFile.getName());
			*/
		}
		
		
		return "string";
	}
	
	@RequestMapping(value="/start")
	public String start( HttpServletRequest request ) throws IOException {
		System.out.println("start");
		return "index";
	}
}
