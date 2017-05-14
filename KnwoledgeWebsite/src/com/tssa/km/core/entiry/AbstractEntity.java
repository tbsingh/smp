package com.tssa.km.core.entiry;

import com.google.common.base.Function;

public abstract class AbstractEntity{
    
    // =========================================================================
    // Constants
    // =========================================================================
    
    public static final Function<AbstractEntity, Long> TO_ID = new Function<AbstractEntity, Long>() {
        @Override
        public Long apply(AbstractEntity entity) {
            return entity.getId();
        }
    };

    // =========================================================================
    // Fields
    // =========================================================================

    public static final String ID = "id";
    protected Long id;
    protected Integer version;

    // =========================================================================
    // Constructors
    // =========================================================================

    public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public AbstractEntity() {
        this(null);
    }

    public AbstractEntity(Long id) {
        setId(id);
    }

    public AbstractEntity(long id) {
        this(new Long(id));
    }

    // =========================================================================
    // Public Methods
    // =========================================================================

    public boolean isNew() {
        return id == null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        if (id != null && version == null) {
            setVersion(new Integer(1));
        }
    }

    public boolean isId(long id) {
        return this.id != null && id == this.id;
    }

    public String toString() {
        return "id=[" + id + "] version=[" + version + "]";
    }
 }
