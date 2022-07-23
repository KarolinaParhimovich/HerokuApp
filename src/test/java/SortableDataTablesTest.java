import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Constants.URLS.dataTables;

public class SortableDataTablesTest extends BaseTest {
    @Test
    public void dataTablesTest() {
        driver.get(dataTables);
        String actualLastName = driver.findElement(By.xpath("//table[@id='table1']//td[text()='Bach']")).getText();
        String actualFirstName = driver.findElement(By.xpath("//table[@id='table1']//td[text()='Frank']")).getText();
        String actualSum = driver.findElement(By.xpath("//table[@id='table2']//td[text()='Frank']//following-sibling::td[contains(text(), '$')]")).getText();
        String actualWebSite=driver.findElement(By.xpath("//table[@id='table2']//td[text()='Frank']//following-sibling::td[contains(text(), '//www')]")).getText();
        Assert.assertEquals(actualFirstName, "Frank");
        Assert.assertEquals(actualLastName, "Bach");
        Assert.assertEquals(actualSum, "$51.00");
        Assert.assertEquals(actualWebSite,"http://www.frank.com");
    }
}
