package dev.fakestore.config;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date Binder Configuration
 *
 * @author Misael Landero
 */
@Configuration
public class DateBinderConfig {
    /**
     * <p>
     *     This method configures the dates globally to match the format yyyy-MM-dd
     * </p>
     * @param binder WebDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
