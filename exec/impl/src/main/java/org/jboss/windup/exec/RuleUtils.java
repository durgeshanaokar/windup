package org.jboss.windup.exec;

import org.jboss.windup.config.AbstractRuleProvider;
import org.jboss.windup.config.metadata.RuleMetadataTypes;
import org.ocpsoft.rewrite.config.Rule;
import org.ocpsoft.rewrite.context.Context;

/**
 * Utils for the Rules. Will be likely moved to Windup Utils.
 * 
 * @author Ondrej Zizka, ozizka at redhat.com
 */
public class RuleUtils
{

    /**
     * Describes given rule as "provider-phase - provider-ID [categories...] rule-ID".
     */
    public static String prettyPrintRule(Rule rule)
    {
        StringBuilder builder = new StringBuilder();
        if (rule instanceof Context)
        {
            final Context ctx = (Context) rule;
            AbstractRuleProvider ruleProvider = (AbstractRuleProvider) ctx.get(RuleMetadataTypes.RULE_PROVIDER);
            if (ruleProvider != null)
            {
                builder.append(ruleProvider.getMetadata().getPhase()).append(" - ");
                builder.append(ruleProvider.getMetadata().getID()).append(" ");
            }
        }

        return builder.append(rule.getId()).toString();
    }

}