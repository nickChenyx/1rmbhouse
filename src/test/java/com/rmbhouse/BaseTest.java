package com.rmbhouse;

import com.rmbhouse.configer.DataConfig;
import com.rmbhouse.configer.RootConfig;
import com.rmbhouse.configer.WebAppInitializer;
import com.rmbhouse.configer.WebConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by nickChenyx on 2017/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppInitializer.class, DataConfig.class,RootConfig.class, WebConfig.class})
public class BaseTest {
}
