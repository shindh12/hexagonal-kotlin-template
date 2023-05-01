package com.study.template

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTag
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.library.Architectures.onionArchitecture

@ArchTag("architectureRule")
@AnalyzeClasses(packagesOf = [ArchitectureTest::class])
class ArchitectureTest {


    // Hexagonal Architecture Rules
    @ArchTest
    val architecture = onionArchitecture()
            .domainModels("..domain..")
            .domainServices().withOptionalLayers(true)
            .applicationServices("..application..")
            .adapter("adapter", "..adapter..")

    @ArchTest
    val Domain은_Application을_참조해서는_안된다 = noClasses().that()
            .resideInAPackage("..domain..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..application..")

    @ArchTest
    val Application은_Adapter를_참조해서는_안된다 = noClasses().that()
            .resideInAPackage("..application..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..adapter..")

    @ArchTest
    val Input_Adapter_는_Application_Service를_참조해서는_안된다 = noClasses().that()
            .resideInAPackage("..adapter.input.web..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..application.service..")


    // Other Rules
    @ArchTest
    val MockComponent는_OutputPort에서만_사용되어야_한다 = classes().that()
            .haveSimpleNameStartingWith("Mock")
            .should()
            .resideInAPackage("..adapter.output..")
}