package test.spring.data.infra;

import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;


@SuppressWarnings("serial")
public class PrefixNamingStrategy extends DefaultComponentSafeNamingStrategy {

	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "JPA_";

	@Override
	public String classToTableName(final String className) {
		return this.addPrefix(super.classToTableName(className));
	}

	@Override
	public String collectionTableName(final String ownerEntity,
			final String ownerEntityTable, final String associatedEntity,
			final String associatedEntityTable, final String propertyName) {
		return this.addPrefix(super.collectionTableName(ownerEntity,
				ownerEntityTable, associatedEntity, associatedEntityTable,
				propertyName));
	}

	@Override
	public String logicalCollectionTableName(final String tableName,
			final String ownerEntityTable, final String associatedEntityTable,
			final String propertyName) {
		return this.addPrefix(super.logicalCollectionTableName(tableName,
				ownerEntityTable, associatedEntityTable, propertyName));
	}

	private String addPrefix(final String composedTableName) {

		return PREFIX + composedTableName;// .toUpperCase().replace("_", "");
	}

}
