package species;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import template.human.Brawler;
import core.PointDistrubition;
import exceptions.NpcGeneratorException;
import exporters.BaseZetaCharacterSheet;

public class BrawlerTest {
    
    @Test
    public void testBrawler() throws NpcGeneratorException,
            FileNotFoundException, UnsupportedEncodingException {
        PointDistrubition pointDistribution = new PointDistrubition(
                "Distribution", 7, 5, 3, 13, 9, 5, 5, 0);
        Brawler brawler = new Brawler(pointDistribution);
        
        // int totalPhysicalPoints = 0;
        // for (Integer value : brawler.getPhysicalStats().getAttributtes()
        // .values()) {
        // totalPhysicalPoints += value;
        // }
        // assertEquals(10, totalPhysicalPoints);
        //
        // int totalSocialPoints = 0;
        // for (Integer value :
        // brawler.getSocialStats().getAttributtes().values()) {
        // totalSocialPoints += value;
        // }
        // assertEquals(8, totalSocialPoints);
        //
        // int totalMentalPoints = 0;
        // for (Integer value :
        // brawler.getMentalStats().getAttributtes().values()) {
        // totalMentalPoints += value;
        // }
        // assertEquals(6, totalMentalPoints);
        //
        // int totalTalentPoints = 0;
        // for (Integer value : brawler.getTalentsStats().getTalents().values())
        // {
        // totalTalentPoints += value;
        // }
        // assertEquals(13, totalTalentPoints);
        //
        // int totalSkillPoints = 0;
        // for (Integer value : brawler.getSkillsStats().getSkills().values()) {
        // totalSkillPoints += value;
        // }
        // assertEquals(9, totalSkillPoints);
        //
        // int totalKnowledgePoints = 0;
        // for (Integer value : brawler.getKnowledgesStats().getKnowledges()
        // .values()) {
        // totalKnowledgePoints += value;
        // }
        // assertEquals(5, totalKnowledgePoints);
        
        BaseZetaCharacterSheet zeta = new BaseZetaCharacterSheet();
        zeta.exportCharacter(brawler, "Brawler");
    }
}
