package org.jodconverter.sample.springboot;

import java.util.HashMap;
import org.jodconverter.office.OfficeManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class CompatConverterController extends ConverterController {

    /**
     * Creates a new controller.
     *
     * @param officeManager The manager used to execute conversions.
     */
    public CompatConverterController(OfficeManager officeManager) {
        super(officeManager);
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public Object index() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping(value = "/converter", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Object convert(
            @RequestParam("inputFile") final MultipartFile inputFile,
            @RequestParam(name = "outputFormat") final String outputFormat) {
        return convert(inputFile, outputFormat, new HashMap<>());
    }


}
