package com.jklearn.blog.timer;

import cn.hutool.core.io.FileUtil;
import com.jklearn.blog.domain.*;
import com.jklearn.blog.service.*;
import com.jklearn.blog.vo.ArticleVo;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableScheduling
public class BlogTimer {

    @Resource
    private ArticlesService articlesService;

    @Resource
    private LabelsService labelsService;

    @Resource
    private SortsService sortsService;

    @Resource
    private UsersService usersService;

    @Resource
    private SetArtitleSortService setArtitleSortService;

    @Resource
    private SetArtitleLabelService setArtitleLabelService;

    @Scheduled(cron = "10 42 * * * ?")
    private void task(){
        List<ArticleVo> articleVos = this.getArticleInfo();
        for (ArticleVo vo : articleVos) {
            Articles a = vo.getArticle();
            ArrayList<Labels> labels = vo.getArticleLabels();
            Sorts sort = vo.getArticleSort();
            if (a != null) {
                StringBuffer articleFile = new StringBuffer("");
                StringBuffer path = new StringBuffer("D:\\hexo\\blog\\source\\_posts\\");
                articleFile.append("---");
                articleFile.append("\ntitle: ").append(a.getArticleTitle());
                articleFile.append("\ndate: ").append(a.getArticleDate());
                articleFile.append("\ncomment: true");
                articleFile.append("\ncategories:");
                articleFile.append("\n- ").append(sort.getSortName());
                articleFile.append("\ntags:");
                for (Labels label : labels ) {
                    articleFile.append("\n- ").append(label.getLabelName());
                }
                articleFile.append("\n---\n");
                articleFile.append(a.getArticleContent());
                path.append(a.getArticleTitle()).append(".md");
                System.out.println(articleFile);
                System.out.println(path);
                FileUtil.touch(FileUtil.writeUtf8String(String.valueOf(articleFile), String.valueOf(path)));
            }
        }
    }

    private List<ArticleVo> getArticleInfo(){
        List<Articles> articlesList = articlesService.selectAll();
        List<ArticleVo> articleVoList = new ArrayList<>();
        SetArtitleSort articleSort = new SetArtitleSort();
        for (Articles article : articlesList) {
            ArticleVo avo = new ArticleVo();
            articleSort  = setArtitleSortService.queryById(article.getArticleId());
            List<SetArtitleLabel> articleLabelList = setArtitleLabelService.queryById(article.getArticleId());
            ArrayList<Labels> articleLabels = new ArrayList<>();
            Sorts s = new Sorts();
            Users u = new Users();
            for (SetArtitleLabel label:
                    articleLabelList) {
                Labels l = labelsService.selectLabelById(label.getLabelId());
                articleLabels.add(l);
            }
            if (articleSort != null) {
                s = sortsService.selectSortById(articleSort.getSortId());
            }
            u = usersService.selectUserById(article.getUserId());
            avo.setArticle(article);
            avo.setArticleLabels(articleLabels);
            avo.setArticleSort(s);
            avo.setUser(u);
            articleVoList.add(avo);
        }
        return articleVoList;
    }
}
