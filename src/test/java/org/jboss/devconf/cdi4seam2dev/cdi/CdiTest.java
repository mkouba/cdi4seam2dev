package org.jboss.devconf.cdi4seam2dev.cdi;

import java.lang.annotation.Annotation;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.jboss.devconf.cdi4seam2dev.cdi.domain.Translator;
import org.jboss.devconf.cdi4seam2dev.util.TestConstants;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class CdiTest {

	public static WebArchive createTestArchiveBase() {
		return ShrinkWrap
				.create(WebArchive.class)
				.addPackage(Translator.class.getPackage())
				.addClasses(CdiTest.class)
				.addAsLibraries(
						ShrinkWrap.create(JavaArchive.class).addPackage(
								TestConstants.class.getPackage()))
				.addAsWebInfResource(EmptyAsset.INSTANCE,
						ArchivePaths.create("beans.xml"));
	}

	@Inject
	protected BeanManager beanManager;

	/**
	 * 
	 * @param beanType
	 * @param scopeType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T lookup(Class<T> beanClass, Annotation... qualifiers) {

		Bean<?> bean = beanManager.resolve(beanManager.getBeans(beanClass,
				qualifiers));

		if (bean == null)
			return null;

		return (T) beanManager.getReference(bean, beanClass,
				beanManager.createCreationalContext(bean));
	}

}
