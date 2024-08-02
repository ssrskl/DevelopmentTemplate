package com.maoyan;

import cn.dev33.satoken.SaManager;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(name = "DevelopmentTemplateToken", type = SecuritySchemeType.HTTP, scheme ="bearer", in = SecuritySchemeIn.HEADER)
@MapperScan(value = "com.maoyan.mapper")
public class DevelopmentTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevelopmentTemplateApplication.class, args);
        System.out.println(
                "\033[1;91m" + "       \\`*-.\n" +
                        "\033[1;91m" + "        )  _`-.\n" +
                        "\033[1;92m" + "       .  : `. .\n" +
                        "\033[1;93m" + "       : _   '  \\\n" +
                        "\033[1;94m" + "       ; *` _.   `*-._\n" +
                        "\033[1;95m" + "       `-.-'          `-.\n" +
                        "\033[1;96m" + "         ;       `       `.\n" +
                        "\033[1;91m" + "         :.       .        \\\n" +
                        "\033[1;92m" + "         . \\  .   :   .-'   .\n" +
                        "\033[1;93m" + "         '  `+.;  ;  '      :\n" +
                        "\033[1;94m" + "         :  '  |    ;       ;-.\n" +
                        "\033[1;95m" + "         ; '   : :`-:     _.`* ;\n" +
                        "\033[1;96m" + "     .*' /  .*' ; .*`- +'  `*'\n" +
                        "\033[1;91m" + "      `*-*   `*-*  `*-*'\n" +
                        "\033[1;92m" + "      启动成功!!! \033[0m");
        System.out.println("启动成功，SaToken的配置如下：" + SaManager.getConfig());
    }
}
