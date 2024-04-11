package org.example;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;



public class Main {
    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        //String fileName = "iflt-0.5-win6zy2/src/main/java/org/examplefuzzyTeste.fcl";

        String fileName = "C:/Users/WazPC/OneDrive/Documentos/sciflt-0.5-win64-bin-61/sciflt/fuzzyLogic/Fuzzy2/src/main/java/org/example/fuzzyTeste.fcl";
        FIS fis = FIS.load(fileName, true);
        if (fis == null) { // Error while loading?
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show ruleset
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        functionBlock.setVariable("distancia", 27);
        functionBlock.setVariable("velocidade", 200);

        // Evaluate
        functionBlock.evaluate();

        // Show output variable's chart
        Variable freagem = functionBlock.getVariable("freagem");
        JFuzzyChart.get().chart(freagem, freagem.getDefuzzifier(), true);
        //Gpr.debug("fraco: " + functionBlock.getVariable("distancia").getMembership("moderada"));

        // Print ruleSet
        System.out.println(functionBlock);
        System.out.println("freagem:" + functionBlock.getVariable("freagem").getValue());
    }
}
