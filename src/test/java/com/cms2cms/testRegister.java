package com.cms2cms;

import java.util.Random;
import org.openqa.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.text.*;
import java.io.*;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

public class testRegister
{

    private static String name = randomString();
    private static String email = name + "@gmail.com";
    private static String password = randomString();
    private static String phone = randomInt();
    private static Properties prop;
    public static WebDriver driver = new FirefoxDriver();

    @Before
    public void setUp()
    {
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        prop = new Properties();
        InputStream input = null;
        try
        {
            String OS = System.getProperty("os.name").toLowerCase();
            if (OS.indexOf("win") >= 0)
            {
                input = new FileInputStream("config.properties");
            }
            prop.load(input);
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        System.setProperty("webdriver.gecko.driver", prop.getProperty("path_to_gecko"));
    }

    @Test
    public void testRegisterTestEmail()
    {
        String fakeEmailString = randomString();

        driver.navigate().to(prop.getProperty("url"));

        driver.findElement(By.id("signUpEmail")).sendKeys("a@g");

        driver.findElement(By.id("signUpPassword")).sendKeys(password);

        driver.findElement(By.id("signUpName")).sendKeys(name);

        driver.findElement(By.id("signUpPhone")).sendKeys(phone);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpEmail-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpEmail")).clear();

        driver.findElement(By.id("signUpEmail")).sendKeys("a");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpEmail-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpEmail")).clear();

        driver.findElement(By.id("signUpEmail")).sendKeys("a@");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpEmail-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpEmail")).clear();

        driver.findElement(By.id("signUpEmail")).sendKeys("aaa@g.");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpEmail-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpEmail")).clear();

        driver.findElement(By.id("signUpEmail")).sendKeys("a@g.");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpEmail-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpEmail")).clear();

        driver.findElement(By.id("signUpEmail")).sendKeys("a@g.c");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpEmail-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpEmail")).clear();

        driver.findElement(By.id("signUpEmail")).sendKeys("a@.co");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpEmail-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpEmail")).clear();

        driver.findElement(By.id("signUpEmail")).sendKeys("12345678901234567890123456789012345678901234567890123456789012345@g.com");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpEmail-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void testRegisterTestPassword()
    {
        driver.navigate().to(prop.getProperty("url"));

        driver.findElement(By.id("signUpEmail")).sendKeys(email);

        driver.findElement(By.id("signUpPassword")).sendKeys("1");

        driver.findElement(By.id("signUpName")).sendKeys(name);

        driver.findElement(By.id("signUpPhone")).sendKeys(phone);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpPassword-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpPassword")).clear();

        driver.findElement(By.id("signUpPassword")).sendKeys("1234a");

        sleep();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpPassword-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpPassword")).clear();

        driver.findElement(By.id("signUpPassword")).sendKeys("123456789012345678901234567890123456789012345678901");

        sleep();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpPassword-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

    }

    @Test
    public void testRegisterTestName()
    {
        driver.navigate().to(prop.getProperty("url"));

        driver.findElement(By.id("signUpEmail")).sendKeys(email);

        driver.findElement(By.id("signUpPassword")).sendKeys(password);

        driver.findElement(By.id("signUpName")).sendKeys("N");

        driver.findElement(By.id("signUpPhone")).sendKeys(phone);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpName-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpName")).clear();

        driver.findElement(By.id("signUpName")).sendKeys("Name");

        sleep();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpName-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void testRegisterTestPhone()
    {
        driver.navigate().to(prop.getProperty("url"));

        driver.findElement(By.id("signUpEmail")).sendKeys(email);

        driver.findElement(By.id("signUpPassword")).sendKeys(password);

        driver.findElement(By.id("signUpName")).sendKeys(name);

        driver.findElement(By.id("signUpPhone")).sendKeys("1");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpPhone-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpPhone")).clear();

        driver.findElement(By.id("signUpPhone")).sendKeys("12345");

        sleep();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpPhone-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

        driver.findElement(By.id("signUpPhone")).clear();

        driver.findElement(By.id("signUpPhone")).sendKeys("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");

        sleep();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.id("signUpPhone-error")).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }

    }

    @Test
    public void testRegisterTestGood()
    {
        driver.navigate().to(prop.getProperty("url"));

        driver.findElement(By.id("signUpEmail")).sendKeys("a" + email);

        driver.findElement(By.id("signUpPassword")).sendKeys(password);

        driver.findElement(By.id("signUpName")).sendKeys(name);

        driver.findElement(By.id("signUpPhone")).sendKeys(phone);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try
        {
            Assert.assertTrue(driver.findElement(By.linkText(name)).isDisplayed());
        } catch (NoSuchElementException nsee)
        {
            Assert.assertFalse(true);
        }
    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }

    private static String randomString()
    {
        String beforeScramble = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        String afterScramble = "";

        Random rn = new Random();

        for (int i = 0; i < 15; i++)
        {
            afterScramble = afterScramble + beforeScramble.charAt(rn.nextInt(beforeScramble.length()));
        }
        return afterScramble;
    }

    private static String randomInt()
    {
        String beforeScramble = "1234567890";

        String afterScramble = "";

        Random rn = new Random();

        for (int i = 0; i < 15; i++)
        {
            afterScramble = afterScramble + beforeScramble.charAt(rn.nextInt(beforeScramble.length()));
        }
        return afterScramble;
    }

    private static void sleep()
    {
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException ie)
        {
            System.out.println("Thread dont work");
        }
    }
}
