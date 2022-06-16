package com.course.controller;

import com.document.utils.Tool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@RestController
public class ShowCodeController {


    @GetMapping("/showCode")
    public void showCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Tool.initCodeData();
        int out_code_length = Tool.OUT_CODE_LENGTH;
        int out_code_width =   Tool.OUT_CODE_WIDTH;
        int out_code_height =  Tool.OUT_CODE_HEIGHT;
        int out_code_width_random = Tool.OUT_CODE_WIDTH_RANDOM;
        int out_code_height_random = Tool.OUT_CODE_HEIGHT_RANDOM;
        int out_code_font_size =  Tool.OUT_CODE_FONT_SIZE;
        int out_code_size_random = Tool.OUT_CODE_SIZE_RANDOM;
        int out_code_line_size =  Tool.OUT_CODE_LINE_SIZE;
        String[] CODES= Tool.CODES;
        Color[] COLORS=Tool.COLORS;



        Random random = new Random();
        String code = "";
        for(int i = 0; i < out_code_length; i ++) {
            code += CODES[random.nextInt(CODES.length)];
        }
        HttpSession session = req.getSession();
        session.setAttribute("code", code);
        BufferedImage bi = new BufferedImage(out_code_width, out_code_height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, out_code_width, out_code_height);
        for(int i = 0; i < out_code_length; i ++) {
            g.setFont(new Font("幼圆", Font.BOLD, out_code_font_size + random.nextInt(out_code_size_random)));
            g.setColor(COLORS[random.nextInt(COLORS.length)]);
            g.drawString(code.charAt(i) + "",
                    (out_code_width / out_code_length)*i + random.nextInt(out_code_width_random),
                    out_code_height /2 + random.nextInt(out_code_height_random));
        }
        for(int i = 0; i < out_code_line_size; i++) {
            g.setColor(COLORS[random.nextInt(COLORS.length)]);
            g.drawLine(random.nextInt(out_code_width),random.nextInt(out_code_height),random.nextInt(out_code_width),random.nextInt(out_code_height));
        }
        ImageIO.write(bi, "jpg", resp.getOutputStream());
        System.out.println(code);
    }

}
