/**
 * Created on Jan 16, 2012
 */
package info.halo9pan.examples.prospring3.ch22.service.impl;

import info.halo9pan.examples.prospring3.ch22.domain.Contact;
import info.halo9pan.examples.prospring3.ch22.rule.domain.Rule;
import info.halo9pan.examples.prospring3.ch22.rule.engine.RuleEngine;
import info.halo9pan.examples.prospring3.ch22.rule.factory.RuleFactory;
import info.halo9pan.examples.prospring3.ch22.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author Clarence
 *
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	ApplicationContext ctx;

	@Autowired
	private RuleFactory ruleFactory;

	@Autowired
	private RuleEngine ruleEngine;

	public void applyRule(Contact contact) {

		// Apply ageCategory rule
		ruleFactory = ctx.getBean("ruleFactory", RuleFactory.class);
		Rule ageCategoryRule = ruleFactory.getAgeCategoryRule();
		ruleEngine.run(ageCategoryRule, contact);

	}

}
