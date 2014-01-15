package de.unirostock.sems.bivesWsClient;

import java.util.List;
import java.util.Map;

public class BivesResult {
	
	/*
{
  "reportMd" : "SBML Differences\n===================\n\n* Both documents have same Level/Version: *L2V4*\n\n",
  "compHierarchyDot" : null,
  "documentType" : {
    "versionA" : [ "XML", "SBML" ],
    "versionB" : [ "XML", "SBML" ]
  },
  "reportHtml" : "<h1>SBML Differences</h1><ul><li>Both documents have same Level/Version: <strong>L2V4</strong></li></ul>",
  "compHierarchyGraphml" : null,
  "crnGraphml" : "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<graphml>\n    <key attr.name=\"name\" attr.type=\"string\" for=\"node\" id=\"name\"/>\n    <key attr.name=\"node set\" attr.type=\"string\" for=\"node\" id=\"ns\">\n        <default>species</default>\n    </key>\n    <key attr.name=\"reversible\" attr.type=\"boolean\" for=\"node\" id=\"rev\">\n        <default>false</default>\n    </key>\n    <key attr.name=\"fast\" attr.type=\"boolean\" for=\"node\" id=\"fast\">\n        <default>false</default>\n    </key>\n    <key attr.name=\"version\" attr.type=\"int\" for=\"all\" id=\"vers\">\n        <default>0</default>\n    </key>\n    <key attr.name=\"modifier\" attr.type=\"string\" for=\"edge\" id=\"mod\">\n        <default>none</default>\n    </key>\n    <key attr.name=\"initial amount\" attr.type=\"double\" for=\"node\" id=\"init\">\n        <default>0</default>\n    </key>\n    <graph edgedefault=\"directed\" id=\"G\">\n        <node id=\"c1\">\n            <data key=\"vers\">0</data>\n            <data key=\"name\">compartment</data>\n            <graph edgedefault=\"directed\" id=\"G1\">\n                <node id=\"s5\">\n                    <data key=\"ns\">species</data>\n                    <data key=\"vers\">0</data>\n                    <data key=\"name\">free E3F</data>\n                </node>\n                <node id=\"s1\">\n                    <data key=\"ns\">species</data>\n                    <data key=\"vers\">0</data>\n                    <data key=\"name\">cycE/cdk2</data>\n                </node>\n                <node id=\"s2\">\n                    <data key=\"ns\">species</data>\n                    <data key=\"vers\">0</data>\n                    <data key=\"name\">RB-Phos</data>\n                </node>\n                <node id=\"s4\">\n                    <data key=\"ns\">species</data>\n                    <data key=\"vers\">0</data>\n                    <data key=\"name\">RB-Hypo</data>\n                </node>\n                <node id=\"s3\">\n                    <data key=\"ns\">species</data>\n                    <data key=\"vers\">0</data>\n                    <data key=\"name\">RB/E2F</data>\n                </node>\n                <node id=\"r2\">\n                    <data key=\"ns\">reaction</data>\n                    <data key=\"vers\">0</data>\n                    <data key=\"name\">r</data>\n                </node>\n                <node id=\"r1\">\n                    <data key=\"ns\">reaction</data>\n                    <data key=\"vers\">0</data>\n                    <data key=\"name\">s</data>\n                </node>\n            </graph>\n        </node>\n        <edge source=\"s3\" target=\"r2\">\n            <data key=\"mod\">none</data>\n            <data key=\"vers\">0</data>\n        </edge>\n        <edge source=\"r2\" target=\"s5\">\n            <data key=\"mod\">none</data>\n            <data key=\"vers\">0</data>\n        </edge>\n        <edge source=\"r2\" target=\"s2\">\n            <data key=\"mod\">none</data>\n            <data key=\"vers\">0</data>\n        </edge>\n        <edge source=\"s1\" target=\"r2\">\n            <data key=\"mod\">stimulator</data>\n            <data key=\"vers\">0</data>\n        </edge>\n        <edge source=\"s2\" target=\"r1\">\n            <data key=\"mod\">none</data>\n            <data key=\"vers\">0</data>\n        </edge>\n        <edge source=\"r1\" target=\"s4\">\n            <data key=\"mod\">none</data>\n            <data key=\"vers\">0</data>\n        </edge>\n    </graph>\n</graphml>\n",
  "xmlDiff" : "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<bives type=\"fullDiff\">\n    <update/>\n    <delete/>\n    <insert/>\n    <move/>\n</bives>\n",
  "crnDot" : "##Command to produce the pic: `neato -Tpng thisfile > thisfile.png`\n\ndigraph BiVeSexport {\n\tgraph [overlap=false];\n\tedge [len=1.3];\n\tnode [fontsize=11];\n\tsubgraph clusterc1 {\n\t\tlabel = \"compartment\";\n\t\tcolor=lightgrey;\n\t\ts5[label=\"free E3F\",shape=circle];\n\t\ts1[label=\"cycE/cdk2\",shape=circle];\n\t\ts2[label=\"RB-Phos\",shape=circle];\n\t\ts4[label=\"RB-Hypo\",shape=circle];\n\t\ts3[label=\"RB/E2F\",shape=circle];\n\t\tr2[label=\"r\",shape=diamond];\n\t\tr1[label=\"s\",shape=diamond];\n\t}\n\ts3->r2;\n\tr2->s5;\n\tr2->s2;\n\ts1->r2[style=dashed,arrowType=normal];\n\ts2->r1;\n\tr1->s4;\n\tlabel=\"Diff Graph created by BiVeS\";\n}",
  "meta" : {
    "versionA" : {
      "nodeStats" : {
        "reaction" : 2,
        "model" : 1,
        "listOfReactions" : 1,
        "listOfReactants" : 2,
        "species" : 5,
        "sbml" : 1,
        "listOfSpecies" : 1,
        "listOfModifiers" : 1,
        "listOfProducts" : 2,
        "modifierSpeciesReference" : 1,
        "listOfCompartments" : 1,
        "speciesReference" : 5,
        "compartment" : 1
      },
      "modelId" : null,
      "sbmlLevel" : 2,
      "modelName" : "TestModel_for_IB2013",
      "sbmlVersion" : 4
    },
    "versionB" : {
      "nodeStats" : {
        "reaction" : 2,
        "model" : 1,
        "listOfReactions" : 1,
        "listOfReactants" : 2,
        "species" : 5,
        "sbml" : 1,
        "listOfSpecies" : 1,
        "listOfModifiers" : 1,
        "listOfProducts" : 2,
        "modifierSpeciesReference" : 1,
        "listOfCompartments" : 1,
        "speciesReference" : 5,
        "compartment" : 1
      },
      "modelId" : null,
      "sbmlLevel" : 2,
      "modelName" : "TestModel_for_IB2013",
      "sbmlVersion" : 4
    }
  }
}
	
	 */
	
	private Map<String, List<String>> documentType;
	
	 
	private String crnDot;
	private String reportMd;
	private String reportHtml;
	
	public BivesResult() {
		// TODO Auto-generated constructor stub
	}

}
