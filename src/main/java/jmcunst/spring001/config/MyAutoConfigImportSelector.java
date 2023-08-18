package jmcunst.spring001.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "jmcunst.spring001.config.autoconfig.DispatcherServletConfig",
                "jmcunst.spring001.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
