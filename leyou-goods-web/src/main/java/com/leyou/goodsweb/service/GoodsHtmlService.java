package com.leyou.goodsweb.service;

import com.leyou.goodsweb.utils.ThreadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author xu7777777
 * @date 2020/3/11 7:17 PM
 */
@Service
public class GoodsHtmlService {

    @Resource
    private GoodsService goodsService;

    @Resource
    private TemplateEngine templateEngine;

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsHtmlService.class);

    /**
     * 创建html页面
     *
     * @param spuId
     * @throws Exception
     */
    public void createHtml(Long spuId) {

        PrintWriter writer = null;
        try {
            // 获取页面数据
            Map<String, Object> spuMap = this.goodsService.loadData(spuId);

            // 创建thymeleaf上下文对象
            Context context = new Context();
            // 把数据放入上下文对象
            context.setVariables(spuMap);

            // 创建输出流
            File file = new File("/usr/local/etc/nginx/html/item/" + spuId + ".html");
            writer = new PrintWriter(file);

            // 执行页面静态化方法
            templateEngine.process("item", context, writer);
        } catch (Exception e) {
            LOGGER.error("页面静态化出错：{}，"+ e, spuId);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * 新建线程处理页面静态化
     * @param spuId
     */
    public void asyncExcute(Long spuId) {
        ThreadUtils.execute(()->createHtml(spuId));
        /*ThreadUtils.execute(new Runnable() {
            @Override
            public void run() {
                createHtml(spuId);
            }
        });*/
    }
}