package poly.edu.tv00103_lab8.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import poly.edu.tv00103_lab8.interceptor.AuthInterceptor;
import poly.edu.tv00103_lab8.interceptor.LogInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    AuthInterceptor authInterceptor;

    @Autowired
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // ✅ Bảo mật các đường dẫn
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/admin/**",
                        "/account/change-password",
                        "/account/edit-profile",
                        "/order/**")
                .excludePathPatterns("/admin/home/index");

        // ✅ Ghi log cho các trang được bảo mật
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/admin/**",
                        "/account/change-password",
                        "/account/edit-profile",
                        "/order/**");
    }
}
